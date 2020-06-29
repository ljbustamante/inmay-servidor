package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Usuario;

public interface UsuarioDAO {
	public int guardarUsuario(Usuario bean);
	public int actualizarUsuario(Usuario bean);
	public Usuario buscarUsuario(int codigo);
	public List<Usuario> listarUsuarios();
	public int eliminarUsuario(int codigo);
}

