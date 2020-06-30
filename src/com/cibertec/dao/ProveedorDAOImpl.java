package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Proveedor;
import com.cibertec.interfaces.ProveedorDAO;
import utils.MysqlDBConexion;

public class ProveedorDAOImpl implements ProveedorDAO{
	@Override
	public int guardarProveedor(Proveedor bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_saveProveedor(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getEmpresa());
			cstm.setString(2,bean.getCargo());
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
	public int actualizarProveedor(Proveedor bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_updateProveedor(?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, bean.getIdProveedor());
			cstm.setString(2,bean.getEmpresa());
			cstm.setString(3,bean.getCargo());
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
	public int eliminarProveedor(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_deleteProveedor(?)";
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
	public Proveedor buscarProveedor(int codigo) {
		Proveedor bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findProveedor(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Proveedor();
				bean.setIdProveedor(rs.getInt(1));
				bean.setEmpresa(rs.getString(2));
				bean.setCargo(rs.getString(3));
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
	public List<Proveedor> listarProveedores() {
		List<Proveedor> lista=new ArrayList<Proveedor>();
		Proveedor bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listProveedor()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Proveedor();
				bean.setIdProveedor(rs.getInt(1));
				bean.setEmpresa(rs.getString(2));
				bean.setCargo(rs.getString(3));
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


