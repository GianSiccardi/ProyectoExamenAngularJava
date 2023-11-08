package com.sistema.examen.sistemaexamenesbackend.controladores;

import com.sistema.examen.sistemaexamenesbackend.modelo.Categoria;
import com.sistema.examen.sistemaexamenesbackend.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<Categoria>guardarCategoria(@RequestBody Categoria categoria){
     Categoria categoriaGuardada=categoriaService.agregarCategoria(categoria);
     return ResponseEntity.ok(categoriaGuardada);
    }
    @GetMapping("/{categoriaId}")
    public Categoria listarCategoriaById(@PathVariable ("categoriaId")Long categoriaId){
        return categoriaService.obtnerCategoriaById(categoriaId);

    }
    @GetMapping("/")
    public ResponseEntity<?>listarTodasCategorias(){
        return ResponseEntity.ok(categoriaService.obtnerCategorias());
    }

    @PutMapping("/")
    public Categoria actualizarCategoria(@RequestBody Categoria categoria ){
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public void eliminarCategoria(@PathVariable("categoriaId")Long id){
        categoriaService.eliminarCategoria(id);
    }
}
