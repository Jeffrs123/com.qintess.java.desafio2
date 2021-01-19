package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qintess.conexaoDB.ConexaoDB;
import com.qintess.dvdrental.entidades.City;

public class CityDao{

	public int create(String city, int idCountry) throws SQLException {

		Connection conn = ConexaoDB.abreConexao();
		int idCity = 0;
		try{
					
			conn.setAutoCommit(false);
			
			String sqlCity = "INSERT INTO CITY(CITY, COUNTRY_ID) VALUES (?,?) RETURNING CITY_ID  ";
			PreparedStatement psCity = conn.prepareStatement(sqlCity,PreparedStatement.RETURN_GENERATED_KEYS);
			
			psCity.setString(1, city);
			psCity.setInt(2, idCountry);
			
			psCity.executeUpdate();
			ResultSet rs = psCity.getGeneratedKeys();
			
			if(rs.next()) {
				idCity = psCity.getGeneratedKeys().getInt("city_id");
			}
			
			conn.commit();

		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

		return idCity;
	}

	public int searchCity(String city) {
		
		
		int idCity = 0;
		int retorno = 0;
		
		try(Connection conn = ConexaoDB.abreConexao()){
			
			try {
				
				conn.setAutoCommit(false);
				String sqlCity = "SELECT CITY_ID FROM CITY WHERE CITY = ? ";
				PreparedStatement psCity = conn.prepareStatement(sqlCity,PreparedStatement.RETURN_GENERATED_KEYS);
				psCity.setString(1, city);
				
				ResultSet rs = psCity.executeQuery();
				
				while(rs.next()) {
					
					idCity = rs.getInt("CITY_ID");
				}
				
				if(idCity > 0 ) {
					retorno = idCity;
				}else {
					retorno = 0;				
				}
				
				conn.commit();
			}catch(Exception e) {
				e.printStackTrace();
				conn.rollback();
			}finally {
				conn.close();
			}
			

		}catch(Exception e) {

			e.printStackTrace();
			
		}

		return retorno;

	}




}
