package com.qintess.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.qintess.conexaoDB.ConexaoDB;

public class LanguageDao {

	public int searchLanguage(String language) {

		int idLanguage = 0;
		int retorno = 0;

		try(Connection conn = ConexaoDB.abreConexao()){

			try {

				conn.setAutoCommit(false);

				String sqlLanguage= "SELECT LANGUAGE_ID FROM LANGUAGE WHERE NAME = ? ";
				PreparedStatement psLanguage = conn.prepareStatement(sqlLanguage);
				psLanguage.setString(1, language);

				ResultSet rs = psLanguage.executeQuery();

				while(rs.next()) {
					idLanguage = rs.getInt("LANGUAGE_ID");
				}

				if(idLanguage > 0 ) {
					retorno = idLanguage;
				}else {
					retorno = 0;				
				}

				conn.commit();

			}catch(Exception e) {
				e.printStackTrace();
				conn.rollback();
			}


		}catch(Exception e) {

			e.printStackTrace();
		}

		return retorno;


	}

	public int create(String languageName) {


		int languageId = 0;
		try(Connection conn = ConexaoDB.abreConexao()){

			try{

				conn.setAutoCommit(false);

				String sqlLanguage= "INSERT INTO LANGUAGE(NAME) VALUES(?) RETURNING LANGUAGE_ID";
				PreparedStatement psLanguage = conn.prepareStatement(sqlLanguage,PreparedStatement.RETURN_GENERATED_KEYS);
				psLanguage.setString(1, languageName);


				psLanguage.executeUpdate();
				ResultSet rs = psLanguage.getGeneratedKeys();

				if(rs.next()) {
					languageId = psLanguage.getGeneratedKeys().getInt("language_id");
				}

				conn.commit();


			}catch(Exception e) {

				e.printStackTrace();
				conn.rollback();
			}


		}catch(Exception e) {
			e.printStackTrace();
		}




		return languageId;

	}

}
