package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qintess.conexaoDB.ConexaoDB;

public class CountryDao {



	public int searchCountry(String country) {
		
		int idCountry = 0;
		int retorno = 0;
		
		try(Connection conn = ConexaoDB.abreConexao()){

			conn.setAutoCommit(false);

			String sqlCountry= "SELECT COUNTRY_ID FROM COUNTRY WHERE COUNTRY = ? ";
			PreparedStatement psCountry = conn.prepareStatement(sqlCountry);
			psCountry.setString(1, country);
			
			
			ResultSet rs = psCountry.executeQuery();
			
			while(rs.next()) {
				
				idCountry = rs.getInt("COUNTRY_ID");
				
			}
			
			if(idCountry > 0 ) {
				retorno = idCountry;
			}else {
				retorno = 0;				
			}
			

		}catch(Exception e) {

			e.printStackTrace();
		}

		return retorno;


	}
	
	
	public int create(String country) throws SQLException {
		
		Connection conn = ConexaoDB.abreConexao();
		int countryId = 0;
		try {
			
			conn.setAutoCommit(false);
			
			String sqlCountry = "INSERT INTO COUNTRY(COUNTRY) VALUES (?) RETURNING COUNTRY_ID";
			PreparedStatement psCountry = conn.prepareStatement(sqlCountry,PreparedStatement.RETURN_GENERATED_KEYS);
			psCountry.setString(1, country);
			
			psCountry.executeUpdate();
			ResultSet rs = psCountry.getGeneratedKeys();
			
			if(rs.next()) {
				countryId = psCountry.getGeneratedKeys().getInt("country_id");
			}
			
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		
		return countryId;
	}

}
