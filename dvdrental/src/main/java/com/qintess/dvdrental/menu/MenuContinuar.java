package com.qintess.dvdrental.menu;

import java.util.Scanner;

import com.qintess.dvdrental.erro.Erro;

public class MenuContinuar {

	public static void getContinue() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("\nDeseja continuar?\n"
					+ "Escolha uma opção\n"
					+ "0- encerrar o programa\n"
					+ "1- voltar ao menu principal\n");
			int continuar = in.nextInt();
			if (continuar == 0) {
				System.out.println("Programa encerrado!");
				in.close();
			}
			else if (continuar == 1) {
				in.reset();
				MenuInicial.iniciarMenu();
			}
			else {
				System.err.println("Você digitou uma opção inválida!");
				Erro.primeiroErro();			}
		} catch (Exception e) {
			System.err.println("Você digitou uma opção que não é um número!");
			Erro.primeiroErro();		}
	}
}
