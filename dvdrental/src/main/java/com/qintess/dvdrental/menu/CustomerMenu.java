package com.qintess.dvdrental.menu;

import java.util.Scanner;

import com.qintess.dvdrental.dao.CityDao;
import com.qintess.dvdrental.dao.CountryDao;
import com.qintess.dvdrental.dao.CustomerDao;
import com.qintess.dvdrental.dao.FullAddressDao;
import com.qintess.dvdrental.erro.Erro;
import com.qintess.dvdrental.menu.metodos.Executavel;


public class CustomerMenu {


	public static void menuCustomer() {
		try {
			Scanner in = new Scanner(System.in);
			CustomerDao customerDao = new CustomerDao();
			FullAddressDao fullAddDao = new FullAddressDao();
			CityDao cityDao = new CityDao();
			CountryDao countryDao = new CountryDao();
			Executavel execute = new Executavel();



			int condicao;

			System.out.println("Digite uma das opções.\n"
					+ "0- Encerrar o programa\n"
					+ "1- Voltar ao menu inicial\n"
					+ "2- Buscar todos os dados de um cliente por ID\n"
					+ "3- Buscar dados pessoais e endereço de um cliente por ID\n"
					+ "4- Listar todos os clientes\n"
					+ "5- Alterar dados pessoais de um cliente\n"
					+ "6- Alterar Endereço de um cliente\n"
					+ "7- Inserir um novo cliente\n"
					+ "8- Deletar um Cliente");

			condicao = in.nextInt();

			switch (condicao) {
			case 0: {
				System.out.println("Programa encerrado!");
				System.exit(0);
				break;
			}
			case 1:{
				in.reset();
				MenuInicial.iniciarMenu();
				break;
			}
			case 2: {
				
				execute.searchById();
				in.reset();
				break;
			}
			case 3: {
				execute.searchCustomerFullAddress();
				in.reset();
				break;
			}
			case 4: {
				System.out.println("Listar todos os clientes");

				///FAZER 
				break;
			}
			case 5: {
				execute.updateCustomer();
				in.reset();
				break;
			}
			case 6:{
				execute.updateCustomerAddress();
				in.reset();
				break;
			}
			case 7: {
				
				execute.insertNewCustomer();
				in.reset();				
				break;
			}
			case 8: {
				
				execute.deleteCustomer();
				in.reset();
				break;
			}
			default:{
				in.close();
				System.err.println("você digitou uma opção inválida!");
				Erro.primeiroErro();
				break;
			}

			}
		} catch (Exception e) {
			System.err.println("Você digitou um valor que não é um número!");
			Erro.primeiroErro();

		}finally {
			MenuContinuar.getContinue();
		}
	}


	
}
