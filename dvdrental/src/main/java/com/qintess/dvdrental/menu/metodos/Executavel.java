package com.qintess.dvdrental.menu.metodos;

import java.util.Scanner;

import com.qintess.dvdrental.dao.CityDao;
import com.qintess.dvdrental.dao.CountryDao;
import com.qintess.dvdrental.dao.CustomerDao;
import com.qintess.dvdrental.dao.FilmDao;
import com.qintess.dvdrental.dao.FullAddressDao;
import com.qintess.dvdrental.dao.LanguageDao;
import com.qintess.dvdrental.erro.Erro;
import com.qintess.dvdrental.menu.CallScanner;

public class Executavel {


	Scanner in = new Scanner(System.in);
	CustomerDao customerDao = new CustomerDao();
	FullAddressDao fullAddDao = new FullAddressDao();
	CityDao cityDao = new CityDao();
	CountryDao countryDao = new CountryDao();
	FilmDao filmDao = new FilmDao();
	LanguageDao languageDao = new LanguageDao();

	//CUSTOMER MENU
	public void searchById() {

		try {
			int id = Integer.parseInt(CallScanner.solicitarUserInput("o ID do cliente"));	
			System.out.println(customerDao.buscarPorId(id));

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void searchCustomerFullAddress() {

		try {
			int id = Integer.parseInt(CallScanner.solicitarUserInput("o ID do cliente"));	
			System.out.println(customerDao.buscarCustomerEnderecoCompleto(id));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void listCustomer() {

	}

	public void updateCustomer() {


		try {
			int idStore = 0;
			
			int idCust = Integer.parseInt(CallScanner.solicitarUserInput("o ID do cliente que deseja alterar"));
			System.out.println("Digite os novos dados do cliente\n");
			String name = CallScanner.solicitarUserInput("o nome");
			String lastName =CallScanner.solicitarUserInput("o sobrenome");
			String email = CallScanner.solicitarUserInput("o email");
			idStore = Integer.parseInt(CallScanner.solicitarUserInput("a loja frequentada pelo(a) cliente: \n 1- 47 MySakila Drive \n 2-28 MySQL Boulevard"));
			int active = Integer.parseInt(CallScanner.solicitarUserInput("1 para deixar o cliente ativo ou 0 para Inativo"));
			
			boolean podeProsseguir = false;
			while(!podeProsseguir) {
				idStore = Integer.parseInt(CallScanner.solicitarUserInput("a loja frequentada pelo(a) cliente: \n 1- 47 MySakila Drive \n 2-28 MySQL Boulevard"));
				if(idStore == 1 || idStore == 2) {
					podeProsseguir = true;
				}
			}

			String retorno = customerDao.update(idStore, name, lastName, email, active, idCust);
			System.out.println(retorno);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void updateCustomerAddress() {

		try {
			// ALTERAR ADDRESS
			int cityId = 0;
			int cityId_pam = 0;
			int countryId = 0;
			int countryId_pam;
			System.out.println("Alterar o endereço do Cliente\n");
			int addressId = Integer.parseInt(CallScanner.solicitarUserInput("o Id do cliente que deseja alterar"));
			String address = CallScanner.solicitarUserInput("o novo endereço do(a) cliente");
			String country = CallScanner.solicitarUserInput("o País");

			// verificar country 				
			countryId = countryDao.searchCountry(country);
			if(countryId == 0) 
				countryId_pam = countryDao.create(country);
			else 
				countryId_pam = countryId;

			String city = CallScanner.solicitarUserInput("a cidade");	

			// verifica city e retorna id 		
			cityId = cityDao.searchCity(city);

			if(cityId == 0) 					
				cityId_pam = cityDao.create(city, countryId_pam);
			else 
				cityId_pam =  cityId;


			String district = CallScanner.solicitarUserInput("o distrito");	
			double postalCode = Double.parseDouble(CallScanner.solicitarUserInput("o código postal"));
			double phone =Double.parseDouble(CallScanner.solicitarUserInput("o número de telefone"));

			String retorno = fullAddDao.update(address, district, cityId_pam, postalCode, phone, addressId);
			System.out.println(retorno);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNewCustomer() {

		try {

			System.out.println("Inserir um novo cliente\n");

			//TODO- Verificar numeros 
			int idStore = Integer.parseInt(CallScanner.solicitarUserInput(" número da loja frequentada: \n 1 - 47 MySakila Drive \n 2- 28 MySQL Boulevard"));
			String firstName = CallScanner.solicitarUserInput("o primeiro nome do(a) cliente ");
			String lastName = CallScanner.solicitarUserInput("o sobrenome do(a) cliente ");
			String email =  CallScanner.solicitarUserInput("o email do(a) cliente ");				
			int active = 1;

			//verifica se País já existe 
			String countryName = CallScanner.solicitarUserInput("o  País em que o(a) cliente reside  ");	
			int idCountry = countryDao.searchCountry(countryName);
			int countryIdFixed = 0;

			if(idCountry == 0) {
				countryIdFixed = countryDao.create(countryName);					
			}else {
				countryIdFixed = idCountry;					
			}

			// verifica se Cidade ja existe

			String city = CallScanner.solicitarUserInput("a cidade em que mora ");		

			int cityId = cityDao.searchCity(city);
			int cityIdFixed = 0;
			if(cityId == 0 ) {
				cityIdFixed = cityDao.create(city, countryIdFixed);
			}else {
				cityIdFixed = cityId;
			}

			// insere endereço

			String district = CallScanner.solicitarUserInput("o distrito da cidade do(a) cliente ");	
			int postalCode = Integer.parseInt(CallScanner.solicitarUserInput("o código postal do endereço do(a) cliente "));	

			int phone = Integer.parseInt(CallScanner.solicitarUserInput("o telefone do(a) cliente "));	

			String address = CallScanner.solicitarUserInput("o endereço do(a) cliente");

			int addressID = fullAddDao.create(address, district, cityIdFixed, postalCode, phone);

			String retornoCreateCustomer = customerDao.create(idStore, firstName, lastName, email, addressID, active);		

			System.out.println(retornoCreateCustomer);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer() {

		try {
			int addressId = Integer.parseInt(CallScanner.solicitarUserInput("endereço id "));
			String retorno =  fullAddDao.delete(addressId);
			System.out.println(retorno);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//FILM MENU
	public void insertNewFilm() {

		try {
			System.out.println("Inserir um novo filme\n");

			String filmName = CallScanner.solicitarUserInput("o nome do filme");
			String description = CallScanner.solicitarUserInput("a descrição do filme ");
			int releaseYear = Integer.parseInt(CallScanner.solicitarUserInput("o ano de lançamento"));
			String languageName = CallScanner.solicitarUserInput("a linguagem do filme");
			
			//verifica se existe 
			
			int idRetorno = languageDao.searchLanguage(languageName);
			int idLanguage = 0;
			if(idRetorno != 0 ) {
				idLanguage = idRetorno;
			}else {
				idLanguage = languageDao.create(languageName);
			}

			int rentalDuration = Integer.parseInt(CallScanner.solicitarUserInput("o tempo de locação"));
			double rentalRate = Double.parseDouble(CallScanner.solicitarUserInput("a taxa de locação"));
			int lenght =Integer.parseInt(CallScanner.solicitarUserInput("a duração do filme"));
			double replacementCost = Double.parseDouble(CallScanner.solicitarUserInput("o custo de reposição"));
			double rating = Double.parseDouble(CallScanner.solicitarUserInput("a avaliação do filme"));
			String features = CallScanner.solicitarUserInput("as características especiais");
			String fullText = CallScanner.solicitarUserInput("o texto completo");
			
			String retorno = filmDao.create(filmName, description, releaseYear,
					idLanguage, rentalDuration, rentalRate,
					lenght, replacementCost, rating, features, fullText);

			System.out.println(retorno);
			System.out.println("  ");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}

