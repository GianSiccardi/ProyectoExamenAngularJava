package com.sistema.examen.sistemaexamenesbackend.servicios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.modelo.Pregunta;

import java.util.Set;

public interface PreguntaService {

    Pregunta agregarPregunta(Pregunta pregunta);
    Pregunta actualizarPregunta(Pregunta pregunta);
    Set<Pregunta> obtenerPreguntas();

    Pregunta obtenerPregunta(Long preguntaId);
    Set<Pregunta>obtenerPreguntasExamen(Examen examen);

    void eliminarPregunta(Long id);

    Pregunta listarPregunta(Long preguntaId);

}
