package com.qintess.dvdrental.menu;

import java.util.Scanner;

public class CallScanner implements AutoCloseable {

	private static Scanner sc = new Scanner(System.in);
	static String result = "Nada definido";

	public static String solicitarUserInput(String texto) {
		try {

			System.out.println("Digite " + texto + ": ");
			result = sc.nextLine();
		} catch (Exception e) {
			System.err.println("Erro ao solicitar user input: " + e);
		}

		return result;
	}


	public void close() throws Exception {
		sc.close();
		System.out.println("Conexão foi fechada");
	}

}
