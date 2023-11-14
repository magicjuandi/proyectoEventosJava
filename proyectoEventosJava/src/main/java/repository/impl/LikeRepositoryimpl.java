package repository.impl;

import domain.models.Like;
import domain.models.Producto;
import domain.models.Usuario;
import singledomain.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeRepositoryimpl {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    public Like creaLike(ResultSet resultSet) throws SQLException {
        Like like = new Like();
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getLong("id_usuario"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCorreo(resultSet.getString("correo"));
        usuario.setContrasena(resultSet.getString("contraseña"));
        usuario.setEstado(resultSet.getString("estado_usuario"));
        like.setUsuario(usuario);
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id_producto"));
        producto.setNombre(resultSet.getString("nombre_producto"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setEstado(resultSet.getString("estado_producto"));
        like.setProducto(producto);
        like.setEstado(resultSet.getString("estado"));
        return like;
    }
    public List<Like> listaLikes(){
        List<Like> likesList = new ArrayList<Like>();
        try (Statement stat = getConnection().createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM likes WHERE estado = 0")) {
            while (rs.next()) {
                Like like = creaLike(rs);
                likesList.add(like);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likesList;
    }
    public void guardarLike(Like like) throws SQLException {
        String sql = "";
        if (like.getUsuario().getId() != null && like.getUsuario().getId() > 0 && like.getProducto().getId() != null
                && like.getProducto().getId() > 0) {
            sql = "INSERT INTO likes (id_usuario, id_producto) VALUES (?,?) ON DUPLICATE KEY UPDATE likes.estado = 1;";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setLong(1, like.getUsuario().getId());
            stmt.setLong(2, like.getProducto().getId());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
