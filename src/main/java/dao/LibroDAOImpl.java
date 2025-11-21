package dao;

import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO{
    @Override
    public void addLibro(Libro libro) throws Exception {
        String sql = "INSERT INTO libro VALUES(,?,?)";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getIsbn());
        ps.executeUpdate();
    }

    @Override
    public List<Libro> getAllLibros() throws Exception {
        String sql = "SELECT * FROM libro";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Libro> libros = new ArrayList<Libro>();
        while (rs.next()) {
            Libro libro = new Libro();
            libro.setId(rs.getInt("id"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setIsbn(rs.getString("isbn"));
            libros.add(libro);
        }
        return libros;
    }

    @Override
    public Libro getLibroById(int id) throws Exception {
        String sql = "SELECT * FROM libro WHERE id = ?";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Libro libro = null;
        while (rs.next()) {
            libro = new Libro();
            libro.setId(rs.getInt("id"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setIsbn(rs.getString("isbn"));
        }
        return libro;
    }

    @Override
    public void updateLibro(Libro libro) throws Exception {
        String sql = "UPDATE libro SET titulo = ?, isbn = ? WHERE id = ?";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getIsbn());
        ps.setInt(3, libro.getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteLibro(int id) throws Exception {
        String sql = "DELETE FROM libro WHERE id = ?";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
