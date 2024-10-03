package com.example.formativajavier.clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String imagen;
    private String nombre;
    private String curso;

    public Usuario(String imagen, String nombre, String curso) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.curso = curso;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }
}