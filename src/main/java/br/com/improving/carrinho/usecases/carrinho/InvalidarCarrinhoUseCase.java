package br.com.improving.carrinho.usecases.carrinho;

import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.singletons.Supermercado;

public class InvalidarCarrinhoUseCase {

	public static void execute() {
		final String identificacaoCliente = ScreenHelper.readString("Informe a identificação do cliente: ");
		final boolean invalidado = Supermercado.getInstance()
				.getFactory()
				.invalidar(identificacaoCliente);

		if (invalidado == true) {
			ScreenHelper.imprimirEPausar("Carrinho invalidado com sucesso!");
		} else {
			ScreenHelper.imprimirEPausar("Erro ao invalidar o carrinho!");
		}
	}
}
