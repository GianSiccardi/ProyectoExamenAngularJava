package com.sistema.examen.sistemaexamenesbackend.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "preguntas")
@Data
public class Pregunta {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long preguntaId;
@Column(length = 5000)
private String contenido;
private String imagen;
private String opcion1;
private String opcion2;
private String opcion3;
private String opcion4;
@Transient//para q no se persista en la tabla
private String respuestaDada;

private String respuesta;

@ManyToOne(fetch = FetchType.EAGER)
private Examen examen;

    public Pregunta() {
    }

    public Pregunta(Long preguntaId, String contenido, String imagen, String opcion1, String opcion2, String opcion3, String opcion4, String respuesta, Examen examen) {
        this.preguntaId = preguntaId;
        this.contenido = contenido;
        this.imagen = imagen;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.respuestaDada = respuesta;
        this.examen = examen;
    }
}
