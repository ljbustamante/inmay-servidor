package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cibertec.entidad.Cliente;
import com.cibertec.interfaces.ClienteDAO;
import utils.MysqlDBConexion;

public class ClienteDAOImpl implements ClienteDAO{
	@Override
	public int guardarCliente(Cliente bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_guardarCliente(?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, bean.getNombre());
			cstm.setString(2, bean.getApellido());
			cstm.setString(3, bean.getDni());
			cstm.setInt(4, bean.getEdad());
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
	public List<Cliente> listarClientesPorEdad(int minimo, int maximo) {
		List<Cliente> lista=new ArrayList<Cliente>();
		Cliente bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listarClientes(?, ?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, minimo);
			cstm.setInt(2, maximo);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new Cliente();
				bean.setIdCliente(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setDni(rs.getString(4));
				bean.setEdad(rs.getInt(5));
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


