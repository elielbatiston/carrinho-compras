package br.com.improving.carrinho.menus;

import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.strategy.OpcaoMenuEnum;

public class Menu {

	public static void show() {
		int opcao;

		do {
			ScreenHelper.clearConsole();
			ScreenHelper.imprimir("================== MENU ================== ");
			ScreenHelper.imprimir("1- Cadastro de produtos");
			ScreenHelper.imprimir("2- Vender");
			ScreenHelper.imprimir("3- Ticket médio");
			ScreenHelper.imprimir("4- Invalidar o carrinho");
			ScreenHelper.imprimir("9- Sair do sistema");

			ScreenHelper.imprimir(" ");
			opcao = ScreenHelper.readInt("Opção: ");

			OpcaoMenuEnum menu = OpcaoMenuEnum.getInstance(opcao);
			menu.acao();
		} while(opcao != 9);
	}
}
