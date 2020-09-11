public class Animal {
  private String species;
  private char gender;
  private int health;
  private int strength;

  // Method Overloading
  public Animal() {

  }

  public Animal(String species, char gender, int strength) {
    this.species = species;
    this.gender = gender;
    this.health = 100;
    this.strength = strength;
  }

  // Getters and Setters
  public String getSpecies() {
    return this.species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public char getGender() {
    return this.gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void battle(String powerMove, Animal target) {
    // Define the logic of how animal attacks
    int damage;
    if (powerMove.equals("roar")) {
      damage = 3;
    } else if (powerMove.equals("bear hug")) {
      damage = 10;
    } else if (powerMove.equals("defaultMove")) {
      damage = 2;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // Multiply Strength x Damage
    int effectiveDamage = this.strength * damage;

    // reduce the target health by effectiveDamage
    target.health -= effectiveDamage;

    // print to the console what just happened
    System.out.printf("%s attacks %s for %d health points\n", this.species, target.species, effectiveDamage);
    System.out.println("target health: " + target.health);
  }

  public void battle(Animal target) {
    this.battle("defaultMove", target);
  }
}