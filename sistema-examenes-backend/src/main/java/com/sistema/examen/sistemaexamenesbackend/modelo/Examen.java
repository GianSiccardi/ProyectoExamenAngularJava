package com.sistema.examen.sistemaexamenesbackend.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity


public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examenId;

    private String titulo;

    private String descripcion;

    private String puntosMaximos;

    private String numeroPreguntas;

    private boolean activo=false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    @OneToMany(mappedBy="examen",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pregunta> preguntaSet=new HashSet<>();

    public Examen() {
    }

    public Examen(Long examenId, String titulo, String descripcion, String puntosMaximos, String numeroPreguntas, boolean activo, Categoria categoria, Set<Pregunta> preguntaSet) {
        this.examenId = examenId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntosMaximos = puntosMaximos;
        this.numeroPreguntas = numeroPreguntas;
        this.activo = activo;
        this.categoria = categoria;
        this.preguntaSet = preguntaSet;
    }

    public Long getExamenId() {
        return examenId;
    }

    public void setExamenId(Long examenId) {
        this.examenId = examenId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntosMaximos() {
        return puntosMaximos;
    }

    public void setPuntosMaximos(String puntosMaximos) {
        this.puntosMaximos = puntosMaximos;
    }

    public String getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(String numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Pregunta> getPreguntaSet() {
        return preguntaSet;
    }

    public void setPreguntaSet(Set<Pregunta> preguntaSet) {
        this.preguntaSet = preguntaSet;
    }
}
