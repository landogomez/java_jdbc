package org.example;

import org.example.models.Producto;
import org.example.repositorio.ProductoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;


public class EjemploJDBCDelete {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {


            Repositorio<Producto> repositorio = new ProductoRepositorio();
            System.out.println("========== listar ==========");
            repositorio.getAll().forEach(System.out::println);

            System.out.println("========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== eliminar ==========");
            

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
