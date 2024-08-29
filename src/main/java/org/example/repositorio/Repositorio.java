package org.example.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> getAll();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);


}
