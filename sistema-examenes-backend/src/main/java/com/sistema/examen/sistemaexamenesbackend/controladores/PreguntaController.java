package com.sistema.examen.sistemaexamenesbackend.controladores;

import com.sistema.examen.sistemaexamenesbackend.modelo.Examen;
import com.sistema.examen.sistemaexamenesbackend.modelo.Pregunta;
import com.sistema.examen.sistemaexamenesbackend.servicios.ExamenService;
import com.sistema.examen.sistemaexamenesbackend.servicios.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

@Autowired
    private PreguntaService preguntaService;
@Autowired
    private ExamenService examenService;


@PostMapping("/")
    public ResponseEntity<Pregunta>guardarPregunta(@RequestBody Pregunta pregunta){

    return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
}


    @PutMapping("/")
    public ResponseEntity<Pregunta>actualizarPregunta(@RequestBody Pregunta pregunta){

        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }

    @GetMapping("/examen/{examenId}")
public ResponseEntity<?> listarPreguntaDelExamen(@PathVariable ("examenId") Long examenId){

        Examen examen=examenService.obtnerExamenById(examenId);

        Set<Pregunta> preguntas=examen.getPreguntaSet();

        List examenes =new ArrayList(preguntas);

        if(examenes.size()>Integer.parseInt(examen.getNumeroPreguntas())){
           examenes=examenes.subList(0,Integer.parseInt(examen.getNumeroPreguntas()+1));

        }
        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaById(@PathVariable ("preguntaId")Long id ){
    return preguntaService.obtenerPregunta(id);
    }
    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable ("preguntaId") Long id){
     preguntaService.eliminarPregunta(id);
    }

    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?>listarPreguntasDelExamenComoAdmin(  @PathVariable("examenId")Long id){
    Examen examen=new Examen();

    examen.setExamenId(id);

    Set<Pregunta>preguntas=preguntaService.obtenerPreguntasExamen(examen);
    return ResponseEntity.ok(preguntas);

    }
    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for(Pregunta p : preguntas){
            Pregunta pregunta = this.preguntaService.listarPregunta(p.getPreguntaId());
            if(pregunta.getRespuesta().equals(p.getRespuestaDada())){
                respuestasCorrectas ++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos())/preguntas.size();
                puntosMaximos += puntos;
            }
            if(p.getRespuestaDada() != null){
                intentos ++;
            }
        }

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos",puntosMaximos);
        respuestas.put("respuestasCorrectas",respuestasCorrectas);
        respuestas.put("intentos",intentos);
        return ResponseEntity.ok(respuestas);
    }
}
