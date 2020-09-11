public class Mammal implements Attackable {
  protected String species;
  protected int health;
  protected int strength;

  public String getSpecies() {
    return species;
  }

  public void sleep() {
    this.health += 2;
    System.out.println("zzz");
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public Mammal(String species, int health) {
    this.species = species;
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }

  public void battle(Attackable target) {
    // decrement health
    int damageAmount = 5;
    target.takeDamage(damageAmount);
  }
}