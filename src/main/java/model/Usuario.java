package model;

import java.util.ArrayList;

public class Usuario {

    //prueba
    private String prueba;

    private int id;
    private String nombre;


    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario -> ID=" + id + " Nombre=" + nombre;
    }

}
