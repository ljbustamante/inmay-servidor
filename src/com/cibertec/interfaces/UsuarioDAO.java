package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Usuario;

public interface UsuarioDAO {
	public int guardarUsuario(Usuario bean);
	public List<Usuario> listarUsuarios();
	public int eliminarUsuario(Usuario bean);
}

