package dao;

import model.Prestamo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public void addPrestamo(Prestamo prestamo) throws Exception {
        String sql = "INSERT INTO prestamo (fechaInicio, fechaFin, usuarioId, libroId) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setDate(1, java.sql.Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, java.sql.Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getUsuarioId());
            ps.setInt(4, prestamo.getLibroId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    prestamo.setId(rs.getInt(1));
                }
            }
            System.out.println("DAO: Prestamo insertado -> " + prestamo);
        }
    }

    @Override
    public List<Prestamo> getAllPrestamos() throws Exception {
        String sql = "SELECT id, fechaInicio, fechaFin, usuarioId, libroId FROM prestamo";
        List <Prestamo>lista = new ArrayList<>();

        try  (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new Prestamo(rs.getInt("id"),
                                        rs.getDate("fechaInicio").toLocalDate(),
                                        rs.getDate("fechaFin").toLocalDate(),
                                        rs.getInt("usuarioId"),
                                        rs.getInt("libroId")));
            }
        }

        return lista;
    }

    @Override
    public Prestamo getPrestamoById(int id) throws Exception {
        String sql = "SELECT id, fechaInicio, fechaFin, usuarioId, libroId FROM prestamo WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return new Prestamo (rs.getInt("id"),
                                        rs.getDate("fechaInicio").toLocalDate(),
                                        rs.getDate("fechaFin").toLocalDate(),
                                        rs.getInt("usuarioId"),
                                        rs.getInt("libroId"));
                }
            }
        }
        return null;
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) throws Exception {
        String sql = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, usuarioId = ?, libroId = ? WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setDate(1, java.sql.Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, java.sql.Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getUsuarioId());
            ps.setInt(4, prestamo.getLibroId());
            ps.setInt(5, prestamo.getId());

            ps.executeUpdate();
            System.out.println("DAO: prestamo actualizado ->" + prestamo);
        }
    }

    @Override
    public void deletePrestamo(int id) throws Exception {
        String sql = "DELETE FROM prestamo WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: Prestamo eliminado -> " + id);
        }
    }

    @Override
    public List<Prestamo> getPrestamoByUsuario(int usuarioId) throws Exception {
        String sql = "SELECT id, fechaInicio, fechaFin, usuarioId, libroId FROM prestamo WHERE usuarioId = ?";
        List <Prestamo>lista = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lista.add(new Prestamo(rs.getInt("id"),
                                        rs.getDate("fechaInicio").toLocalDate(),
                                        rs.getDate("fechaFin").toLocalDate(),
                                        rs.getInt("usuarioId"),
                                        rs.getInt("libroId")));
            }
        }
        return lista;
    }

    @Override
    public List<Prestamo> getPrestamoByLibro(int libroid) throws Exception {
        String sql = "SELECT id, fechaInicio, fechaFin, usuarioId, libroId FROM prestamo WHERE libroId = ?";
        List <Prestamo>lista = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, libroid);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lista.add(new Prestamo(rs.getInt("id"),
                                        rs.getDate("fechaInicio").toLocalDate(),
                                        rs.getDate("fechaFin").toLocalDate(),
                                        rs.getInt("usuarioId"),
                                        rs.getInt("libroId")));
            }
        }
        return lista;
    }
}
