package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qintess.conexaoDB.ConexaoDB;
import com.qintess.dvdrental.entidades.Customer;
import com.qintess.dvdrental.entidades.FullAddress;

public class FullAddressDao{

		public int create(String address,String district, int city_id, double postal_code, double phone) throws SQLException {
	
			FullAddress fullAddress = null;
			
			int addressId = 0;
	
			Connection conn = ConexaoDB.abreConexao();
			try{
	
				conn.setAutoCommit(false);
	
				//CREATE ADDRESS
				String sqlAddress = "INSERT INTO ADDRESS(address, district, city_id,postal_code,phone)"
						+ "VALUES(?,?, ?,?,?) RETURNING ADDRESS_ID";			
	
				
				PreparedStatement psAddress = conn.prepareStatement(sqlAddress,PreparedStatement.RETURN_GENERATED_KEYS);
	
	
				psAddress.setString(1, address);
				psAddress.setString(2, district);
				psAddress.setInt(3, city_id);
				psAddress.setDouble(4, postal_code);
				psAddress.setDouble(5, phone);
	
				psAddress.executeUpdate();// Valores: 1 - Quando atualizado; 0 - Quando não.
				ResultSet rs = psAddress.getGeneratedKeys();
	
				if(rs.next()) {
					addressId = psAddress.getGeneratedKeys().getInt("address_id");
				}
	
	
				conn.commit();
	
			}catch(Exception e) {
				System.err.println("Erro ao criar no BD: " + e);
	
				conn.rollback();
			} finally {
	
				//	Fechar conexão.
				conn.close();  
	
			}
	
			return addressId;
	
		}





	// método pesquisa endereço

	public String pesquisaEndereco(String address) {

		FullAddress fullAddress = null;
		String resp = "";		

		try(Connection conn = ConexaoDB.abreConexao()){

			conn.setAutoCommit(false);

			String sqlAddress = "SELECT *  FROM ADDRESS WHERE address LIKE ?";

			PreparedStatement psAddress = conn.prepareStatement(sqlAddress);
			String query = "%" + address + "%";
			psAddress.setString(1, query);

			ResultSet rs = psAddress.executeQuery();

			if(!rs.next()) {
				System.out.println("Endereço não cadastrado");
			}	

			while(rs.next()) {
				System.out.println(rs.getInt("address_id"));


			}




			//conn.commit();




		}catch(Exception e) {
			e.printStackTrace();
		}



		return resp;
	}



	/// método delete address
	public String delete(int id) throws SQLException {

		int idRetorno = 0;
		String resp = ""; // string de retorno de usuário deletado.

		Connection conn = ConexaoDB.abreConexao();
		try {

			conn.setAutoCommit(false);
			String sqlAddress = "DELETE  FROM ADDRESS WHERE ADDRESS_ID = ?";

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public String update(String address, String district, int city_id, double postalCode, double phone, int addressId) throws SQLException {
		
		Connection conn = ConexaoDB.abreConexao();
		String resp = "";
		try {

			conn.setAutoCommit(false);
			String sqlAddress = "UPDATE address SET address = ?, district = ?, city_id = ?, postal_code = ?, phone = ? WHERE address_id = ?";

			PreparedStatement psAddress = conn.prepareStatement(sqlAddress);
			psAddress.setString(1, address);
			psAddress.setString(2, district);
			psAddress.setInt(3, city_id);
			psAddress.setDouble(4, postalCode);
			psAddress.setDouble(5, phone);
			psAddress.setInt(6, addressId);

						
			int retorno = psAddress.executeUpdate();

			if(retorno > 0) {
				resp = " Endereço alterado com sucesso ! ";

			}else {
				resp ="Falha na alteração";
			}
			
			conn.commit();

		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

		return resp;
	}




























}
