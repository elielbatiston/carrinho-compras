package br.com.improving.carrinho.helpers;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScreenHelper {

	public static void clearConsole()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();

		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void imprimir(final String message) {
		System.out.println(message);
	}

	public static void imprimirEPularLinha(String message) {
		imprimir(message);
		imprimir(" ");
	}

	public static void imprimirEPausar(String message) {
		imprimir(" ");
		imprimir(message);
		ScreenHelper.pausar(3*1000);
		ScreenHelper.clearConsole();
	}

	public static Long readLong(String message) {
		final Scanner leitor = new Scanner(System.in);
		imprimir(message);
		final Long valor = leitor.nextLong();
		imprimir(" ");
		return valor;
	}

	public static String readString(String message) {
		final Scanner leitor = new Scanner(System.in);
		imprimir(message);
		final String valor = leitor.nextLine();
		imprimir(" ");
		return valor;
	}

	public static BigDecimal readBigDecimal(String message) {
		final Scanner leitor = new Scanner(System.in);
		imprimir(message);
		final BigDecimal valor = leitor.nextBigDecimal();
		imprimir(" ");
		return valor;
	}

	public static int readInt(String message) {
		final Scanner leitor = new Scanner(System.in);
		imprimir(message);
		final int valor = leitor.nextInt();
		imprimir(" ");
		return valor;
	}

	public static int menuSimOuNao(String mensagem) {
		imprimir(" ");
		imprimir(mensagem);
		imprimir("1- Sim");
		imprimir("2- Não");
		final Scanner leitor = new Scanner(System.in);
		return leitor.nextInt();
	}
	private static void pausar(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
