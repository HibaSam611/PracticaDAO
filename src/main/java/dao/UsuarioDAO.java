package dao;

import model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    //prueba
    void prueba ();

    void addUsuario(Usuario usuario) throws Exception;
    List<Usuario> getAllUsuarios() throws Exception;
    Usuario getUsuarioById(int id) throws Exception;
    void updateUsuario(Usuario usuario) throws Exception;
    void deleteUsuario(int id) throws Exception;

}
