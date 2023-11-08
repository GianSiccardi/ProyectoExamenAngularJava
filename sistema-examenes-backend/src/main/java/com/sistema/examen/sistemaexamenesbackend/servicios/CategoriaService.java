package com.sistema.examen.sistemaexamenesbackend.servicios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;

import java.util.Set;

public interface CategoriaService {


    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    Set<Categoria> obtnerCategorias();
    Categoria obtnerCategoriaById(Long categoriaId);
    void eliminarCategoria(Long id);
}
