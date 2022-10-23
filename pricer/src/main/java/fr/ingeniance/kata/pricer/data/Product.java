package fr.ingeniance.kata.pricer.data;

public class Product {
	
	private String name;

	private String conditionnement;

	private String unit;

	public Product() {
		super();
	}

	public Product(String name) {
		super();
		this.name = name;
	}

	public Product(String name, String conditionnement) {
		super();
		this.name = name;
		this.conditionnement = conditionnement;
	}

	public Product(String name, String conditionnement, String unit) {
		super();
		this.name = name;
		this.conditionnement = conditionnement;
		this.unit = unit;
	}

	public String getConditionnement() {
		return conditionnement;
	}

	public void setConditionnement(String conditionnement) {
		this.conditionnement = conditionnement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
