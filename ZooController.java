import java.util.ArrayList;

public class ZooController {
  public static void main(String[] args) {
    Mammal dolphin = new Mammal("Dolphin", 100);
    Gorilla gorilla = new Gorilla();

    // Since Gorilla's are descendants of the Mammal Parent Class, we can group them
    // into an array list.
    ArrayList<Mammal> animals = new ArrayList<Mammal>();
    animals.add(dolphin);
    animals.add(gorilla);

    for (Mammal m : animals) {
      System.out.println(m.getSpecies());
    }

    // Dolphin (Mammal) object battles gorilla, since gorilla's takeDamage is cut in
    // half, we return the Gorilla only has 2 taken off what would've been 5.
    dolphin.battle(gorilla);
    System.out.println(gorilla.getHealth());

  }
}