package animal;

public class Animal {
	private int health;
	private String species;
	private String name;
	private int strength;
	private String color;
	private int weight;
	
	
	public Animal(int health, String species, String name, int strength, String color, int weight) {
		this.health = health;
		this.species = species;
		this.name = name;
		this.strength = strength;
		this.color = color;
		this.weight = weight;
	}
	
	
	public Animal() {
	}


	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
