package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Ciudad;
import com.cibertec.interfaces.CiudadDAO;
import utils.MysqlDBConexion;

public class CiudadDAOImpl implements CiudadDAO{
	public Ciudad buscarCiudad(int codigo) {
		Ciudad bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findCiudad(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Ciudad();
				bean.setIdCiudad(rs.getInt(1));
				bean.setDescCiudad(rs.getString(2));
				bean.setIdPais(rs.getInt(3));
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
	public List<Ciudad> listarCiudades() {
		List<Ciudad> lista=new ArrayList<Ciudad>();
		Ciudad bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listCiudades()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Ciudad();
				bean.setIdCiudad(rs.getInt(1));
				bean.setDescCiudad(rs.getString(2));
				bean.setIdPais(rs.getInt(3));
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


