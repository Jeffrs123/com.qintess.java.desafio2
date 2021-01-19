package com.qintess.dvdrental.menu;

import java.util.Scanner;

import com.qintess.dvdrental.erro.Erro;

public class MenuInicial {

	public static void iniciarMenu() {
		Scanner in = new Scanner(System.in);	
		try {
			System.out.println("Menu Inicial\n"
					+ "Digite uma das opções a seguir.\n"
					+ "0- Encerrar o Programa\n"
					+ "1- Para Clientes\n"
					+ "2- Para Filmes");

			int condicao = in.nextInt();
			switch(condicao) {
			case 0:{
				in.close();
				System.out.println("Programa encerrado!");
				break;
			}
			case 1:{
				in.reset();
				CustomerMenu.menuCustomer();
				break;
			}
			case 2:{
				in.reset();
				FilmMenu.opcoes();
				break;
			}
			default:{
				System.err.println("você digitou uma opção inválida!");
				Erro.primeiroErro();				break;
			}
			}

		} catch (Exception e) {
			System.err.println("Você digitou um valor que não é um número!");
			Erro.primeiroErro();		}
	}

}
