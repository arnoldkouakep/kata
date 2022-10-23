package fr.ingeniance.kata.pricer.data;

public class Item {

	private Product product;

	private Integer unity;

	private double amount;

	public Item() {
		super();
	}

	public Item(Product product, Integer unity, double amount) {
		super();
		this.product = product;
		this.unity = unity;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getUnity() {
		return unity;
	}

	public void setUnity(Integer unity) {
		this.unity = unity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
