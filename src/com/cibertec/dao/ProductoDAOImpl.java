package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Producto;
import com.cibertec.interfaces.ProductoDAO;
import utils.MysqlDBConexion;

public class ProductoDAOImpl implements ProductoDAO{
	@Override
	public int guardarProducto(Producto bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_saveProducto(?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getDescProducto());
			cstm.setInt(2,bean.getIdCategoria());
			cstm.setInt(3,bean.getStock());
			cstm.setDouble(4,bean.getPrecioU());
			cstm.setInt(5,bean.getIdProveedor());
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
	public int actualizarProducto(Producto bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_updateProducto(?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, bean.getIdProducto());
			cstm.setString(2,bean.getDescProducto());
			cstm.setInt(3,bean.getIdCategoria());
			cstm.setInt(4,bean.getStock());
			cstm.setDouble(5,bean.getPrecioU());
			cstm.setInt(6,bean.getIdProveedor());
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
	public int eliminarProducto(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_deleteProducto(?)";
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
	public Producto buscarProducto(int codigo) {
		Producto bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findProducto(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new Producto();
				bean.setIdProducto(rs.getInt(1));
				bean.setDescProducto(rs.getString(2));
				bean.setIdCategoria(rs.getInt(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecioU(rs.getDouble(5));
				bean.setIdProveedor(rs.getInt(6));
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
	public List<Producto> buscarProductoxPrecio(double p1, double p2) {
		List<Producto> list = new ArrayList<Producto>();
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_findProductoxPrecio(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setDouble(1,p1);
			cstm.setDouble(2,p2);
			rs=cstm.executeQuery();
			while(rs.next()) {
				Producto bean =new Producto();
				bean.setIdProducto(rs.getInt(1));
				bean.setDescProducto(rs.getString(2));
				bean.setIdCategoria(rs.getInt(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecioU(rs.getDouble(5));
				bean.setIdProveedor(rs.getInt(6));
				list.add(bean);
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
		return list;
	}
		
	@Override
	public List<Producto> listarProductos() {
		List<Producto> lista=new ArrayList<Producto>();
		Producto bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listProducto()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Producto();
				bean.setIdProducto(rs.getInt(1));
				bean.setDescProducto(rs.getString(2));
				bean.setIdCategoria(rs.getInt(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecioU(rs.getDouble(5));
				bean.setIdProveedor(rs.getInt(6));
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


