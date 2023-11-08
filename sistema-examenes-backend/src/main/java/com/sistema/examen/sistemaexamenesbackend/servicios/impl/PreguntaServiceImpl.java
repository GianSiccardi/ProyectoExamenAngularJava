package com.sistema.examen.sistemaexamenesbackend.servicios.impl;

import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.modelo.Pregunta;
import com.sistema.examen.sistemaexamenesbackend.repositorios.PreguntaRepository;
import com.sistema.examen.sistemaexamenesbackend.servicios.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PreguntaServiceImpl implements PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Set<Pregunta> obtenerPreguntas() {
      return (Set<Pregunta>) preguntaRepository.findAll();
    }

    @Override
    public Pregunta obtenerPregunta(Long preguntaId) {
        return preguntaRepository.findById(preguntaId).get();
    }

    @Override
    public Set<Pregunta> obtenerPreguntasExamen(Examen examen) {
        return preguntaRepository.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long id) {
    Pregunta pregunta=new Pregunta();
    pregunta.setPreguntaId(id);
    preguntaRepository.delete(pregunta);
    }

    @Override
    public Pregunta listarPregunta(Long preguntaId) {
        return this.preguntaRepository.getOne(preguntaId);
    }
}
