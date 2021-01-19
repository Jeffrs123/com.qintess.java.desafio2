package com.qintess.dvdrental.menu;

import java.util.Scanner;

import com.qintess.dvdrental.dao.CityDao;
import com.qintess.dvdrental.dao.CountryDao;
import com.qintess.dvdrental.dao.CustomerDao;
import com.qintess.dvdrental.dao.FilmDao;
import com.qintess.dvdrental.dao.FullAddressDao;
import com.qintess.dvdrental.dao.LanguageDao;
import com.qintess.dvdrental.erro.Erro;
import com.qintess.dvdrental.menu.metodos.Executavel;

public class FilmMenu {

	public static void opcoes() {

		try{


			Scanner in = new Scanner(System.in);
			Executavel execute = new Executavel();
			
			int condicao;

			System.out.println("Digite uma das opções.\n"
					+ "0- Encerrar o programa\n"
					+ "1- Voltar ao menu inicial\n"
					+ "2- Inserir um novo filme ID\n"	);

			condicao = in.nextInt();	
			switch (condicao) {
			case 0: {
				System.out.println("Programa encerrado!");
				in.reset();
				break;
			}
			case 1:{
				in.reset();
				MenuInicial.iniciarMenu();
				break;
			}
			case 2: {
				execute.insertNewFilm();				
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
