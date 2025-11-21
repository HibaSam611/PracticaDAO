package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void addUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (nombre) VALUES (?)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()){ //lo hace internamente para comprobar que añadir se ha hecho bien
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }

            System.out.println("DAO: usuario insertado -> " + usuario);
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() throws Exception {
        String sql = "SELECT id, nombre FROM usuario";
        List<Usuario> lista = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()) { //creo los usuarios porque en mi java no los tengo creados
                lista.add(new Usuario(rs.getInt(1), rs.getString(2)));
            }
        }

        return lista;
    }

    @Override
    public Usuario getUsuarioById(int id) throws Exception {
        String sql = "SELECT id, nombre FROM usuario WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Usuario(rs.getInt(1), rs.getString(2));
                }
            }
        }
        return null;
    }

    @Override
    public void updateUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET nombre = ? WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getId());

            ps.executeUpdate();
            System.out.println("DAO: usuario actualizado -> " + usuario);
        }
    }

    @Override
    public void deleteUsuario(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("DAO: usuario eliminado -> " + id);

        }
    }


}
