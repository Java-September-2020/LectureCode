public class Gorilla extends Mammal {

  // Directly Calling the Mammal constructor
  public Gorilla() {
    super("gorilla", 500);
  }

  @Override
  public void sleep() {
    this.health += 20;
    System.out.println("zzz");
  }

  public void eatBanana() {
    System.out.println("is eating a banana");
  }

  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }

}