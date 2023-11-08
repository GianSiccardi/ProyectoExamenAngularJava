package com.sistema.examen.sistemaexamenesbackend.repositorios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.modelo.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

Set<Pregunta> findByExamen(Examen examen);

}
