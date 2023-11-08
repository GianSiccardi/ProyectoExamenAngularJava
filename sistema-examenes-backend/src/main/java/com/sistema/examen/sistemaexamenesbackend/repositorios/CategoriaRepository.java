package com.sistema.examen.sistemaexamenesbackend.repositorios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
