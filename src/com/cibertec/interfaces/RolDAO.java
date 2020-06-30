package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.Rol;

public interface RolDAO {
	public Rol buscarRol(int id);
	public List<Rol> listarRoles();
}

