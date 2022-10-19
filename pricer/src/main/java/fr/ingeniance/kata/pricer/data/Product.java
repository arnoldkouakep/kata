package fr.ingeniance.kata.pricer.data;

public class Product {

	private Long id;

	private String code;

	private String conditionnement;

	private String name;

	private String unit;

	public Product() {
		super();
	}

	public Product(Long id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Product(Long id, String code, String conditionnement, String name) {
		super();
		this.id = id;
		this.code = code;
		this.conditionnement = conditionnement;
		this.name = name;
	}

	public Product(Long id, String code, String conditionnement, String name, String unit) {
		super();
		this.id = id;
		this.code = code;
		this.conditionnement = conditionnement;
		this.name = name;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
