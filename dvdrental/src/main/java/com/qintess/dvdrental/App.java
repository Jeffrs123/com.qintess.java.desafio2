package com.qintess.dvdrental;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

import com.qintess.dvdrental.dao.CustomerDao;
import com.qintess.dvdrental.dao.FullAddressDao;
import com.qintess.dvdrental.entidades.Customer;
import com.qintess.dvdrental.menu.MenuInicial;


public class App 
{
	public static void main( String[] args )
	{


		try {	
			
			MenuInicial menu = new MenuInicial();			
			menu.iniciarMenu();

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}








