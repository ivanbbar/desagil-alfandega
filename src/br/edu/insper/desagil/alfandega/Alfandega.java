package br.edu.insper.desagil.alfandega;

import java.util.ArrayList;
import java.util.List;

public class Alfandega {
	private List<Item> itens;
	private List<ItemTarifado> itensTarifados;
	private boolean devido;

	public Alfandega() {
		this.itens = new ArrayList<>();
		this.itensTarifados = new ArrayList<>();
	}

	public void declara(Item item) {
		this.itens.add(item);
	}

	public void declara(ItemTarifado itemTarifado) {
		this.itensTarifados.add(itemTarifado);
	}
	
	public double getTotal(boolean devido) {
		double total = 0.0;
		for (Item item : this.itens) {
			if (devido) {
				total += item.getRate() * item.getValor() * 0.01;
			}
			else {
				total += item.getRate() * item.getValor();
			}
		}
		for (ItemTarifado itemTarifado : this.itensTarifados) {
			if (devido) {
				total += itemTarifado.getRate() * itemTarifado.getValor() * itemTarifado.getTarifa();
			}
			else {
				total += itemTarifado.getRate() * itemTarifado.getValor();
			}
		}
		return total;
}
}
