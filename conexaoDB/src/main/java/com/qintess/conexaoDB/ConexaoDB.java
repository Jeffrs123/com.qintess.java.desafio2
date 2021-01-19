package com.qintess.conexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB implements AutoCloseable {


	private static String url = "jdbc:postgresql://localhost:5432/db_dvdrental";
	private static String user = "postgres";
	private static String pass = "admin";

	private static Connection conn;

	public static Connection abreConexao() throws SQLException {
		conn = DriverManager.getConnection(url, user, pass);
		return conn;
	}

	public void close() throws Exception {
		conn.close();

	}




}

