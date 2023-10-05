package repository.impl;

import domain.models.Producto;
import domain.models.Usuario;
import singledomain.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryimpl {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }
    private Producto creaProducto(ResultSet resultSet)throws SQLException{
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setEstado(resultSet.getString("estado"));
        return producto;
    }
    public void guardarProducto(Producto producto) throws SQLException{
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?, estado=? WHERE id=?;";
        } else {
            sql = "INSERT INTO productos (nombre, precio) VALUES (?,?);";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setString(3, producto.getEstado());
                stmt.setLong(4, producto.getId());
            }
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Producto> listaProductos() {
        List<Producto> productosList = new ArrayList<Producto>();
        try (Statement stat = getConnection().createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM productos WHERE estado = 0")) {
            while (rs.next()) {
                Producto producto = creaProducto(rs);
                productosList.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosList;
    }
    public Producto byId(Long id){
        Producto producto = null;
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM productos WHERE id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                producto = creaProducto(resultSet);
            }
            resultSet.close();
        }catch(SQLException e){
            e.printStackTrace();
        } return producto;
    }
}
