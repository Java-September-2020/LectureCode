public class AnimalController {
  // Entry Point Method
  public static void main(String[] args) {
    Animal tigress = new Animal("Tiger", 'f', 5);
    Animal lion = new Animal("Lion", 'm', 7);
    Animal bear = new Animal("Bear", 'f', 10);

    tigress.battle(lion);
  }
}