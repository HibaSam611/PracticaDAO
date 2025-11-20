package dao;

import model.LibroAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT * FROM libroAutor";
        List<LibroAutor> libroAutores = new ArrayList<LibroAutor>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LibroAutor libroAutor = new LibroAutor();
            libroAutor.setIdLibro(rs.getInt("idLibro"));
            libroAutor.setIdAutor(rs.getInt("idAutor"));
            libroAutores.add(libroAutor);
        }
        return libroAutores;
    }

    @Override
    public LibroAutor getLibrosAutoresById(int idLibro, int idAutor) throws Exception {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT * FROM libroAutor WHERE idLibro = ? AND idAutor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idLibro);
        ps.setInt(2, idAutor);
        ResultSet rs = ps.executeQuery();
        LibroAutor libroAutor = null;
        while (rs.next()) {
            libroAutor = new LibroAutor();
            libroAutor.setIdLibro(rs.getInt("idLibro"));
            libroAutor.setIdAutor(rs.getInt("idAutor"));
            libroAutor.setIdAutor(rs.getInt("idAutor"));
            libroAutor.setIdAutor(rs.getInt("idAutor"));
        }
        return libroAutor ;
    }

    @Override
    public void updateLibroAutor(LibroAutor libroAutor) throws Exception {
        Connection conn = ConnectionManager.getConnection();
        String sql = "UPDATE libroAutor SET idAutor = ? WHERE idLibro = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, libroAutor.getIdAutor());
        ps.setInt(2, libroAutor.getIdLibro());
        ps.executeUpdate();
    }

    @Override
    public void deleteLibroAutor(int idLibro, int idAutor) throws Exception {
        Connection conn = ConnectionManager.getConnection();
        String sql = "DELETE FROM libroAutor WHERE idLibro = ? AND idAutor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idLibro);
        ps.setInt(2, idAutor);
        ps.executeUpdate();
    }
}
