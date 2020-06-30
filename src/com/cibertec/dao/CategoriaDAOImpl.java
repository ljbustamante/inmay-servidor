package com.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Categoria;
import com.cibertec.entidad.Distrito;
import com.cibertec.interfaces.CategoriaDAO;

import utils.MysqlDBConexion;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public Categoria buscarCategoria(int id) {
		Categoria bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findCategoria(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,id);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Categoria();
				bean.setIdCategoria(rs.getInt(1));
				bean.setNombreCat(rs.getString(2));
				bean.setDescripcionCat(rs.getString(3));
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
	public List<Categoria> listarCategoria() {
		List<Categoria> lista=new ArrayList<Categoria>();
		Categoria bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listCategorias()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Categoria();
				bean.setIdCategoria(rs.getInt(1));
				bean.setNombreCat(rs.getString(2));
				bean.setDescripcionCat(rs.getString(3));
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
