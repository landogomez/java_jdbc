package org.example;

import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.repositorio.ProductoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;


public class EjemploJDBC {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {


            Repositorio<Producto> repositorio = new ProductoRepositorio();
            System.out.println("========== listar ==========");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));


            /*System.out.println("========== insertar nuevo producto ==========");
            Producto producto2 = new Producto();
            producto2.setNombre("Teclado Red Dragon Mecanico");
            producto2.setPrecio(450);
            producto2.setFechaRegistro(new Date(new java.util.Date().getTime() ));
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto2.setCategoria(categoria);
            repositorio.guardar(producto2);
            System.out.println("Producto guardado con exito");
            repositorio.getAll().forEach(System.out::println);*/

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
