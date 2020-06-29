package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Distrito;
import com.cibertec.interfaces.DistritoDAO;
import utils.MysqlDBConexion;

public class DistritoDAOImpl implements DistritoDAO{
	public Distrito buscarDistrito(int codigo) {
		Distrito bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findDistrito(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Distrito();
				bean.setIdDistrito(rs.getInt(1));
				bean.setDescDistrito(rs.getString(2));
				bean.setIdProvincia(rs.getInt(3));
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
	public List<Distrito> listarDistritos() {
		List<Distrito> lista=new ArrayList<Distrito>();
		Distrito bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listDistritos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Distrito();
				bean.setIdDistrito(rs.getInt(1));
				bean.setDescDistrito(rs.getString(2));
				bean.setIdProvincia(rs.getInt(3));
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


