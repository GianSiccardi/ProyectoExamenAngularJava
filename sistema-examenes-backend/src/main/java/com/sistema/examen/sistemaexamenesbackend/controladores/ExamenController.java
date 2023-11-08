package com.sistema.examen.sistemaexamenesbackend.controladores;


import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        Examen examenGuardada=examenService.agregarExamen(examen);
        return ResponseEntity.ok(examenGuardada);
    }
    @PutMapping("/")
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen){
        Examen examenGuardada=examenService.actualziarExamen(examen);
        return ResponseEntity.ok(examenGuardada);
    }
    @GetMapping("/{examenId}")
    public Examen listarExamenById(@PathVariable ("examenId")Long examenId){
        return examenService.obtnerExamenById(examenId);

    }
    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamen());

    }


    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable("examenId")Long id){
        examenService.eliminarExamen(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Examen>listarExamenDeUnaCategroia(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria =new Categoria();
        categoria.setCategoriaId(categoriaId);
        return examenService.listarExamenDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<Examen>listarExamensActivos(){
        return examenService.obtenerExamenesActivos();
    }
    @GetMapping("/categoria/activo/{categoriaId}")
    public List<Examen>listarExamensActivosDeUnaCategoria(@PathVariable("categoriaId")Long id){
        Categoria categoria =new Categoria();
        categoria.setCategoriaId(id);
        return examenService.listarExamenDeUnaCategoria(categoria);
    }
}
