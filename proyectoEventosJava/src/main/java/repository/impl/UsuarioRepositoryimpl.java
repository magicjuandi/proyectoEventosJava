package repository.impl;

import com.mysql.cj.protocol.Resultset;
import domain.models.Historico;
import domain.models.Usuario;
import repository.UsuarioRepository;
import singledomain.ConexionDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioRepositoryimpl implements UsuarioRepository {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    public Usuario creaUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getLong("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setContrasena(resultSet.getString("contraseña"));
        usuario.setEstado(resultSet.getString("estado"));
        return usuario;
    }
    public Long getIntento(ResultSet resultSet) throws SQLException {
        Long idU = 0L;
        idU = resultSet.getLong("id");
        return idU;
    }
    public Usuario byId(Long id){
        Usuario usuario = null;
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM usuario WHERE id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                usuario = creaUsuario(resultSet);
            }
            resultSet.close();
        }catch(SQLException e){
            e.printStackTrace();
        } return usuario;
    }
    public Long getIdUser(Usuario usuario){
        Long idU = 0L;
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT id FROM usuario WHERE correo =? AND contraseña = ?")){
            preparedStatement.setString(1,usuario.getCorreo());
            preparedStatement.setString(2,usuario.getContrasena());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                idU = getIntento(resultSet);
            }
            resultSet.close();
        }catch(SQLException e){
            e.printStackTrace();
        }return idU;
    }
    public void guardarUsuario(Usuario usuario) throws SQLException {
        String sql;
        if (validarCorreo(usuario.getCorreo()) == true || usuario.getId() != null) {
            if (usuario.getId() != null && usuario.getId() > 0) {
                sql = "UPDATE usuario SET nombre=?, correo=?, contraseña=?, estado=? WHERE id=?;";
            } else {
                sql = "INSERT INTO usuario (nombre, correo, contraseña) VALUES (?,?,?);";
            }
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getCorreo());
                stmt.setString(3, usuario.getContrasena());
                System.out.println("Usuario Creado!");
                if (usuario.getId() != null && usuario.getId() > 0) {
                    stmt.setString(4, usuario.getEstado());
                    stmt.setLong(5, usuario.getId());
                }
                stmt.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            System.out.println("Este correo ya esta en uso");
        }

    }

    public List<Usuario> listaUsuarios() {
        List<Usuario> usuariosList = new ArrayList<Usuario>();
        try (Statement stat = getConnection().createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM usuario WHERE estado = 0")) {
            while (rs.next()) {
                Usuario usuario = creaUsuario(rs);
                usuariosList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuariosList;
    }

    public boolean validarCorreo(String correo) throws SQLException {
        boolean validar = true;
        int count = 0;
        String sql;
        sql = "SELECT COUNT(*) AS rowcount FROM usuario WHERE correo = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            count = rs.getInt("rowcount");
        }
        if (count > 0) {
            validar = false;
        }
        return validar;
    }

    public String ingresoUsuario(Usuario usuario) throws SQLException {
        String ingreso = "no ha ingresado correctamente";
        String sql;
        int contadorFila = 0;
        sql = "SELECT COUNT(*) AS rowcount FROM usuario WHERE correo = ? AND contraseña = ?;";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, usuario.getCorreo());
        stmt.setString(2, usuario.getContrasena());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            contadorFila = rs.getInt("rowcount");
        }
        if (contadorFila > 0) {
            ingreso = "Ingreso Exitoso!, Bienvenid@";
        }
        return ingreso;
    }

    public void intentos() throws SQLException {
        Scanner scan = new Scanner(System.in);
        HistoricoRepositortimpl hRepo = new HistoricoRepositortimpl();
        int contadorIntento = 1;
        while (contadorIntento != 4) {
            System.out.println("Correo");
            String correoS = scan.next();
            System.out.println("Contraseña");
            String contraS = scan.next();
            Usuario usuario = Usuario.builder()
                    .correo(correoS)
                    .contrasena(contraS).build();
            Long idUser = getIdUser(usuario);
            usuario.setId(idUser);
            System.out.println(ingresoUsuario(usuario));
            if (ingresoUsuario(usuario) == "Ingreso Exitoso!, Bienvenid@") {
                Historico historico = Historico.builder()
                        .usuario(usuario)
                        .intento(contadorIntento).build();
                hRepo.guardarHistorico(historico, contadorIntento);
                contadorIntento = 4;
            } else {
                contadorIntento++;
                System.out.println("Intento fallido " + (contadorIntento-1));
                if (contadorIntento == 4) {
                    System.out.println("Saliendo del apartado de ingreso");
                }
            }
        }
    }
}