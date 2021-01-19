package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qintess.conexaoDB.ConexaoDB;
import com.qintess.dvdrental.entidades.Customer;
import com.qintess.dvdrental.entidades.FullAddress;


public class CustomerDao{



	public Customer buscarPorId(int id) {

		Customer cust = null;

		try(Connection conn = ConexaoDB.abreConexao()) {

			String sql = "select customer_id, first_name, last_name, email from customer where customer_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				cust = new Customer();

				cust.setCustomerId(rs.getInt("customer_id"));
				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cust;
	}


	public Customer buscarCustomerEnderecoCompleto(int id) {

		Customer cust = null;

		try(Connection conn = ConexaoDB.abreConexao()) {

			String sql = "select \r\n"
					+ "		c.customer_id, \r\n"
					+ "		c.first_name, \r\n"
					+ "		c.last_name, \r\n"
					+ "		c.email, \r\n"
					+ "		c.active, \r\n"
					+ "		a.address, \r\n"
					+ "		a.postal_code, \r\n"
					+ "		ci.city,\r\n"
					+ "		co.country\r\n"
					+ "from customer as c\r\n"
					+ "	inner join address as a\r\n"
					+ "		on c.address_id = a.address_id\r\n"
					+ "	inner join city as ci\r\n"
					+ "		on a.city_id = ci.city_id\r\n"
					+ "	inner join country as co\r\n"
					+ "		on ci.country_id = co.country_id\r\n"
					+ " where c.customer_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				cust = new Customer();

				cust.setCustomerId(rs.getInt("customer_id"));
				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
				cust.setActive(rs.getString("active"));

				FullAddress endereco = new FullAddress();

				endereco.setAddress(rs.getString("address"));
				endereco.setPostalCode(rs.getInt("postal_code"));
				endereco.setCity(rs.getString("city"));
				endereco.setCountry(rs.getString("country"));

				cust.setFullAddress(endereco);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cust;


	}




	public String create(int store_id, String first_name, String last_name, String email, int address_id, int active) throws SQLException {

		Customer cust = null;
		String resp = "";

		Connection conn = ConexaoDB.abreConexao();
		try {

			conn.setAutoCommit(false);

			//CREATE CUSTOMER
			String sqlCustomer = "INSERT INTO CUSTOMER(store_id,first_name, last_name, email,address_id,active) VALUES(?,?,?,?,?,?)";
			PreparedStatement psCust = conn.prepareStatement(sqlCustomer);

			psCust.setInt(1, store_id);
			psCust.setString(2, first_name);
			psCust.setString(3, last_name);
			psCust.setString(4, email);
			psCust.setInt(5, address_id);
			psCust.setInt(6, active);	

			int retorno = psCust.executeUpdate();

			if(retorno> 0) {

				resp = "Customer inserido com sucesso !";
			}else {
				resp = "Falha na inserção do Customer";
			}


			conn.commit(); 


		}catch(SQLException e) {
			e.printStackTrace();
			conn.rollback();

		}


		return resp;
	}



	public String update(int store_id, String first_name, String last_name, String email, int active, int id) throws SQLException {

		String resp = "";

		Connection conn = ConexaoDB.abreConexao();
		try {
			conn.setAutoCommit(false);

			//CREATE CUSTOMER
			String sqlCustomer = "UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, email = ?, active = ? WHERE customer_id = ?";
			PreparedStatement psCust = conn.prepareStatement(sqlCustomer);
			psCust.setInt(1, store_id);
			psCust.setString(2, first_name);
			psCust.setString(3, last_name);
			psCust.setString(4, email);
			psCust.setInt(5, active);
			psCust.setInt(6, id);

			int retorno = psCust.executeUpdate();


			if(retorno > 0) {
				resp = " Customer alterado com sucesso ! ";

			}else {
				resp = " Falha na alteração";
			}

			conn.commit();


		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}


		return resp;

	}


	public int delete(int id ) {
		Customer cust = null;
		int retornoAddressId = 0;

		// RETORNAR O ADDRESS_ID DO CLIENTE QUE FOI APAGADO

		try (Connection conn =ConexaoDB.abreConexao()){

			conn.setAutoCommit(false);

			//CREATE CUSTOMER
			String sqlCustomer = "DELETE CUSTOMER WHERE CUSTOMER_ID = ?" ;
			PreparedStatement psCust = conn.prepareStatement(sqlCustomer);
			psCust.setInt(1, id);	

			retornoAddressId = psCust.executeUpdate();






		}catch(Exception e) {
			e.printStackTrace();
		}


		return retornoAddressId;	
	}











}
