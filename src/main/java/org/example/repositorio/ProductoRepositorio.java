package org.example.repositorio;

import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorio implements Repositorio<Producto> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    @Override
    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("select p.*, c.nombre as categoria from productos as p " +
                     "inner join categorias as c on (p.id_categoria = c.id)")){
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        try (PreparedStatement stmt = getConnection().
                prepareStatement("select p.*, c.nombre as categoria from productos as p " +
                        "inner join categorias as c on (p.id_categoria = c.id) where p.id = ?")) {
            stmt.setLong(1,id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    producto = crearProducto(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0)
            sql = "UPDATE productos SET nombre = ?, precio=?, id_categoria = ? where id=?";
        else
            sql = "INSERT INTO productos(nombre, precio, id_categoria,fecha_registro) values(?,?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){

            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0)
                stmt.setLong(4, producto.getId());
            else
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("delete from productos where id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id_categoria"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
