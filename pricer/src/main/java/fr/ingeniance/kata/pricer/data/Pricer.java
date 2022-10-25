package fr.ingeniance.kata.pricer.data;

public class Pricer {

	private Item item;

	private int qte;

	public Pricer() {
		super();
	}

	public Pricer(Item item, int qte) {
		super();
		this.item = item;
		this.qte = qte;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
}
