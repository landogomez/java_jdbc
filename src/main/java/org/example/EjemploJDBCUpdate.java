package org.example;

import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.repositorio.ProductoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;


public class EjemploJDBCUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {


            Repositorio<Producto> repositorio = new ProductoRepositorio();
            System.out.println("========== listar ==========");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== eeditar producto ==========");
            Producto producto = new Producto();
            producto.setId(11L);
            producto.setNombre("Teclado Razer Mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto editado con exito");
            repositorio.getAll().forEach(System.out::println);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
