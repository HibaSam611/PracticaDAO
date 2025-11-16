package model;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {

    //prueba
    private String prueba;

    private int id;
    private Date fechaInicio;
    private Date fechaFin;
//    private Usuario usuario;
//    private Libro libro;

    public Prestamo (int id, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Override
    public String toString() {
        return "Prestamo -> ID=" + id + " Fecha Inicio=" + fechaInicio + " Fecha Fin=" + fechaFin;
    }

}
