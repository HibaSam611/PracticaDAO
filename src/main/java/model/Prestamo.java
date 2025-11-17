package model;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {

    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private int idUsuario;
    private int idlibro;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    @Override
    public String toString() {
        return "Prestamo -> ID=" + id + " Fecha Inicio=" + fechaInicio + " Fecha Fin=" + fechaFin;
    }

}
