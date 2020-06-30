package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Provincia;
import com.cibertec.interfaces.ProvinciaDAO;
import utils.MysqlDBConexion;

public class ProvinciaDAOImpl implements ProvinciaDAO{
	public Provincia buscarProvincia(int codigo) {
		Provincia bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findProvincia(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Provincia();
				bean.setIdProvincia(rs.getInt(1));
				bean.setDescProvincia(rs.getString(2));
				bean.setIdCiudad(rs.getInt(3));
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
	public List<Provincia> listarProvincias() {
		List<Provincia> lista=new ArrayList<Provincia>();
		Provincia bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listProvincia()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Provincia();
				bean.setIdProvincia(rs.getInt(1));
				bean.setDescProvincia(rs.getString(2));
				bean.setIdCiudad(rs.getInt(3));
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


