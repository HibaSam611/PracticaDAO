package dao;

import model.LibroAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class LibroAutorDAOImpl implements LibroAutorDAO{
    @Override
    public void addLibroAutor(LibroAutor libroAutor) throws Exception {
        String sql = "INSERT INTO libroAutor (idLibro, idAutor) VALUES(?,?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, libroAutor.getIdLibro());
            ps.setInt(2, libroAutor.getIdAutor());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if(rs.next()) {
                    libroAutor.setIdLibro(rs.getInt(1));
                    libroAutor.setIdAutor(rs.getInt(2));

                }
                System.out.println("DAO:  LibroAutor insertado -> " + libroAutor);
            }
        }


    }

    @Override
    public List<LibroAutor> getAllLibrosAutores() throws Exception {
        return List.of();
    }

    @Override
    public LibroAutor getLibrosAutoresById(int idLibro, int idAutor) throws Exception {
        return null;
    }

    @Override
    public void updateLibroAutor(LibroAutor libroAutor) throws Exception {

    }

    @Override
    public void deleteLibroAutor(int idLibro, int idAutor) throws Exception {

    }
}
