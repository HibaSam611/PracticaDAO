package dao;

import model.Prestamo;

import java.util.List;

public interface PrestamoDAO {

    //prueba

    void addPrestamo(Prestamo prestamo) throws Exception;
    List<Prestamo> getAllPrestamos() throws Exception;
    Prestamo getPrestamoById(int id) throws Exception;
    void updatePrestamo(Prestamo prestamo) throws Exception;
    void deletePrestamo(int id) throws Exception;

}
