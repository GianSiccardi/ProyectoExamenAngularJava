package com.sistema.examen.sistemaexamenesbackend.repositorios;


import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen,Long> {
    List<Examen> findByCategoria(Categoria categoria);

     List<Examen>findByActivo(Boolean estado);

    List<Examen>findByCategoriaAndActivo(Categoria categoria,Boolean estado);
}
