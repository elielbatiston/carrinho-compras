package br.com.improving.carrinho.usecases.carrinho;

import java.math.BigDecimal;

import br.com.improving.carrinho.helpers.Formatador;
import br.com.improving.carrinho.helpers.ScreenHelper;
import br.com.improving.carrinho.singletons.Supermercado;

public class CalcularTicketMedioUseCase {

	public static void execute() {
		final BigDecimal ticket = Supermercado.getInstance()
				.getFactory()
				.getValorTicketMedio();
		ScreenHelper.imprimirEPausar(String.format("O ticket médio é: %s", Formatador.moeda(ticket)));
	}
}
