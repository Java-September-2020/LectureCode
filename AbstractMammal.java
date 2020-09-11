public abstract class AbstractMammal {
  protected int strength;
  protected int health;
  protected String species;
  protected String name;

  public void breathe() {
    System.out.printf("%s took a deep breath of air", this.name);
    this.strength += 2;
  }

  public void eat() {
    System.out.printf("%s just ate", this.name);
    this.strength += 5;
  }

  public abstract void makeSound();

}