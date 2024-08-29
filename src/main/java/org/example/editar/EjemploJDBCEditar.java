package org.example.editar;

import org.example.models.Producto;
import org.example.repositorio.ProductoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class EjemploJDBCEditar {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {


            Repositorio<Producto> repositorio = new ProductoRepositorio();
            System.out.println("========== listar ==========");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== editar ==========");
            Producto producto = new Producto();
            producto.setId(2L);
            producto.setNombre("Samsun TV");
            producto.setPrecio(150000);
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con exito");





            System.out.println("========== insertar nuevo producto ==========");
            Producto producto2 = new Producto();
            producto2.setNombre("Teclado Mecanico");
            producto2.setPrecio(500);
            producto2.setFechaRegistro(new Date(new java.util.Date().getTime() ));
            repositorio.guardar(producto2);
            System.out.println("Producto guardado con exito");
            repositorio.getAll().forEach(System.out::println);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
