package com.qintess.dvdrental.erro;

import java.util.Scanner;

import com.qintess.dvdrental.menu.MenuInicial;



public class Erro {

	public static void primeiroErro() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Caso digite uma opção errada 3 vezes, o programa será encerrado!\n"
					+ "Tentativas 2/3.\n"
					+ "Digite 0 para encerrar o programa ou 1 para voltar ao menu principal!\n");
			int opcao = in.nextInt();

			if (opcao == 0) {
				System.out.println("Programa encerrado!");
				in.close();
			}else if (opcao == 1 ) {
				MenuInicial.iniciarMenu();
			}else {
				System.err.println("Você digitou uma opção inválida!");
				segundoErro();
			}

		} catch (Exception e) {
			System.err.println("Você digitou um valor que não é um número!");
			segundoErro();
		}
	}

	public static void segundoErro() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Tentativas 3/3.\n"
					+ "Digite 0 para encerrar o programa ou 1 para voltar ao menu principal!\n");
			int opcao = in.nextInt();

			if (opcao == 0) {
				System.out.println("Programa encerrado!");
				in.close();
			}else if (opcao == 1 ) {
				MenuInicial.iniciarMenu();
			}else System.err.println("Você digitou uma opção inválida!\n"
					+ "Quantidade de tentativas excedida!\n"
					+ "Programa encerrado!");
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Você digitou um valor que não é um número!\n"
					+ "Quantidade de tentativas excedida!\n"
					+ "Programa encerrado!");
			System.exit(0);
		}
	}
}

