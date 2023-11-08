package com.sistema.examen.sistemaexamenesbackend.servicios.impl;

import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.repositorios.ExamenRepository;
import com.sistema.examen.sistemaexamenesbackend.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {

@Autowired
private ExamenRepository examenRepository;

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen actualziarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamen() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public Examen obtnerExamenById(Long examenId) {
        return examenRepository.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {

    examenRepository.deleteById(examenId);
    }

    @Override
    public List<Examen> listarExamenDeUnaCategoria(Categoria categoria) {
        return this.examenRepository.findByCategoria(categoria);
    }

    @Override
    public List<Examen> obtenerExamenesActivos() {
        return examenRepository.findByActivo(true);
    }

    @Override
    public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
        return examenRepository.findByCategoriaAndActivo(categoria,true);
    }
}
