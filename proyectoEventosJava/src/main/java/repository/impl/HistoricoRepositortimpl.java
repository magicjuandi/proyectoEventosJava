package repository.impl;

import domain.models.Historico;
import domain.models.Usuario;
import repository.HistoricoRepository;
import singledomain.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoRepositortimpl implements HistoricoRepository {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    public Historico creaHistorico(ResultSet resultSet) throws SQLException {
        Historico historico = new Historico();
        historico.setId(resultSet.getLong("id"));
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getLong("id_usuario"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setContrasena(resultSet.getString("contraseña"));
        usuario.setEstado(resultSet.getString("estado"));
        historico.setUsuario(usuario);
        historico.setIntento(resultSet.getInt("intento"));
        historico.setFecha(resultSet.getDate("fecha").toLocalDate());
        historico.setTiempo(resultSet.getTime("tiempo").toLocalTime());
        historico.setIndicador(resultSet.getString("indicador"));
        return historico;
    }
    public List<Historico> listaHistorico(){
        List<Historico> historicosList = new ArrayList<Historico>();
        try (Statement stat = getConnection().createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM historico, usuario WHERE indicador = 0 AND usuario.id = historico.id_usuario")) {
            while (rs.next()) {
                Historico historico = creaHistorico(rs);
                historicosList.add(historico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicosList;
    }
    public void guardarHistorico(Historico historico, int intento)throws SQLException {
        String sql;
        sql = "INSERT INTO historico (id_usuario, intento, fecha, tiempo) VALUES (?,?,?,?);";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setLong(1, historico.getUsuario().getId());
            stmt.setInt(2, intento);
            stmt.setDate(3, Date.valueOf(historico.getFecha().now()));
            stmt.setTime(4, Time.valueOf(historico.getTiempo().now()));
            System.out.println("Historico Creado!");
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
