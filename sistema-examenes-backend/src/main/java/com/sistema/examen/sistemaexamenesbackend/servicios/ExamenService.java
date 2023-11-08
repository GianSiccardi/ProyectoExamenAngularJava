package com.sistema.examen.sistemaexamenesbackend.servicios;

import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;

import java.util.List;
import java.util.Set;

public interface ExamenService {

Examen agregarExamen(Examen examen);
Examen actualziarExamen(Examen examen);
Set<Examen> obtenerExamen();
Examen obtnerExamenById(Long examenId);
void eliminarExamen(Long examenId);

List<Examen> listarExamenDeUnaCategoria(Categoria categoria);

List<Examen>obtenerExamenesActivos();

    List<Examen>obtenerExamenesActivosDeUnaCategoria(Categoria categoria);
}
