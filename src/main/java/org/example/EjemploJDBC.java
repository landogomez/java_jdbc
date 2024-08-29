package org.example;

import org.example.models.Producto;
import org.example.repositorio.ProductoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;


public class EjemploJDBC {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {


            Repositorio<Producto> repositorio = new ProductoRepositorio();
            /*System.out.println("========== listar ==========");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== editar ==========");
            Producto producto = new Producto();
            producto.setId(2L);
            producto.setNombre("Samsung TV");
            producto.setPrecio(15000);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========= Eliminar producto ==========");
            repositorio.eliminar(4L);
            repositorio.eliminar(5L);
            repositorio.eliminar(6L);
            repositorio.eliminar(7L);
            repositorio.eliminar(8L);

            repositorio.getAll().forEach(System.out::println);*/
            repositorio.getAll().forEach(System.out::println);





            /*System.out.println("========== insertar nuevo producto ==========");
            Producto producto2 = new Producto();
            producto2.setNombre("Teclado Mecanico");
            producto2.setPrecio(500);
            producto2.setFechaRegistro(new Date(new java.util.Date().getTime() ));
            repositorio.guardar(producto2);
            System.out.println("Producto guardado con exito");
            repositorio.getAll().forEach(System.out::println);*/

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
