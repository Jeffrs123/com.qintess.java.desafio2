package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.qintess.conexaoDB.ConexaoDB;

public class FilmDao {
	
	
	// INSERIR FILME 
	public String create(String title, String description, int release_year, 
						int language_id, int rental_duration, double rental_rate, 
						int lenght, double replacement_cost, double rating,
						String special_features, String fulltext ) {
		
		String resp = "";
		try(Connection conn = ConexaoDB.abreConexao()){
			
			
			try {
				
				conn.setAutoCommit(false);
				
				String sqlFilm = "INSERT INTO FILM(title,"
						+ " description, release_year, language_id,"
						+ " rental_duration, rental_rate, length, "
						+ "replacement_cost, rating, special_features, fulltext)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement psFilm = conn.prepareStatement(sqlFilm);
				
				psFilm.setString(1, title);
				psFilm.setString(2, description);
				psFilm.setInt(3, release_year);
				psFilm.setInt(4, language_id);
				psFilm.setInt(5, rental_duration);
				psFilm.setDouble(6, rental_rate);
				psFilm.setInt(7, lenght);
				psFilm.setDouble(8, replacement_cost);
				psFilm.setDouble(9, rating);
				psFilm.setString(10, special_features);
				psFilm.setString(11, fulltext);
				
				int retorno =  psFilm.executeUpdate();
				
				if(retorno > 0) {
					 resp = " Filme inserido com sucesso!";
				}else {
					resp = " Falha na inserção do filme";
				}
				
				
				conn.commit();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
				conn.rollback();
				
			}
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		return resp;
		
	}
	
	

}
