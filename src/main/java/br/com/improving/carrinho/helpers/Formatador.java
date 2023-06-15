package br.com.improving.carrinho.helpers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatador {

	public static String moeda(BigDecimal valor) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
		simbolos.setCurrencySymbol("R$");
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		DecimalFormat formato = new DecimalFormat("R$ #,##0.00", simbolos);
		return formato.format(valor);
	}

}
