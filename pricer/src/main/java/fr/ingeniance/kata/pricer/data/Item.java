package fr.ingeniance.kata.pricer.data;

public class Item {

	private Long id;

	private Product product;

	private Integer unity;

	private double amount;

	public Item() {
		super();
	}

	public Item(Long id, Product product, Integer unity, double amount) {
		super();
		this.id = id;
		this.product = product;
		this.unity = unity;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
