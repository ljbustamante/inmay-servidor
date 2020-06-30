package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Usuario;
import com.cibertec.interfaces.UsuarioDAO;
import utils.MysqlDBConexion;

public class UsuarioDAOImpl implements UsuarioDAO{
	@Override
	public int guardarUsuario(Usuario bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_saveUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getNombreU());
			cstm.setString(2,bean.getApellidoU());
			cstm.setString(3,bean.getEmailU());
			cstm.setString(4,bean.getClaveU());
			cstm.setDate(5,bean.getfRegistroU());
			cstm.setString(6,bean.getDireccionU());
			cstm.setInt(7, bean.getIdPais());
			cstm.setInt(8, bean.getIdCiudad());
			cstm.setInt(9, bean.getIdProvincia());
			cstm.setInt(10, bean.getIdDistrito());
			cstm.setString(11,bean.getTelefonoU());
			cstm.setInt(12, bean.getIdEstadoUsuario());
			cstm.setBoolean(13, bean.isStaff());
			//System.out.println("SENTENCIA : "+cstm+"--");
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int actualizarUsuario(Usuario bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_updateUsuario(?,?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, bean.getIdUsuario());
			cstm.setString(2,bean.getNombreU());
			cstm.setString(3,bean.getApellidoU());
			cstm.setString(4,bean.getEmailU());
			cstm.setString(5,bean.getClaveU());
			cstm.setDate(6,bean.getfRegistroU());
			cstm.setString(7,bean.getDireccionU());
			cstm.setInt(8, bean.getIdPais());
			cstm.setInt(9, bean.getIdCiudad());
			cstm.setInt(10, bean.getIdProvincia());
			cstm.setInt(11, bean.getIdDistrito());
			cstm.setString(12,bean.getTelefonoU());
			cstm.setInt(13, bean.getIdEstadoUsuario());
			cstm.setBoolean(14, bean.isStaff());
			estado=cstm.executeUpdate();
			System.out.println("SENTENCIA : "+cstm+"--");
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int eliminarUsuario(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_deleteUsuario(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			System.out.println("SENTENCIA : "+cstm+"--");
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	@Override
	public Usuario buscarUsuario(int codigo) {
		Usuario bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findUsuario(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setNombreU(rs.getString(2));
				bean.setApellidoU(rs.getString(3));
				bean.setEmailU(rs.getString(4));
				bean.setClaveU(rs.getString(5));
				bean.setfRegistroU(rs.getDate(6));
				bean.setDireccionU(rs.getString(7));
				bean.setIdPais(rs.getInt(8));
				bean.setIdCiudad(rs.getInt(9));
				bean.setIdProvincia(rs.getInt(10));
				bean.setIdDistrito(rs.getInt(11));
				bean.setTelefonoU(rs.getString(12));
				bean.setIdEstadoUsuario(rs.getInt(13));
				bean.setStaff(rs.getBoolean(14));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}	

	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> lista=new ArrayList<Usuario>();
		Usuario bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listUsuario()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setNombreU(rs.getString(2));
				bean.setApellidoU(rs.getString(3));
				bean.setEmailU(rs.getString(4));
				bean.setClaveU(rs.getString(5));
				bean.setfRegistroU(rs.getDate(6));
				bean.setDireccionU(rs.getString(7));
				bean.setIdPais(rs.getInt(8));
				bean.setIdCiudad(rs.getInt(9));
				bean.setIdProvincia(rs.getInt(10));
				bean.setIdDistrito(rs.getInt(11));
				bean.setTelefonoU(rs.getString(12));
				bean.setIdEstadoUsuario(rs.getInt(13));
				bean.setStaff(rs.getBoolean(14));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}


