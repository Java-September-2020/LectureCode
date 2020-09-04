import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling {
  public static void main(String[] args) {
    // Create New Object for random, can now be used for random methods.
    Random r = new Random();
    // Create New Array List For Alphabet
    ArrayList<Character> alphabet = new ArrayList<Character>();
    // Use specialized loop to populate new ArrayList with every char.
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      alphabet.add(ch);
    }

    System.out.println(alphabet);
    // Use Collections Superclass to shuffle contents of ArrayList
    Collections.shuffle(alphabet);
    // Assign random number to variable
    int randomNumber = r.nextInt(25);
    System.out.println(alphabet.get(randomNumber));
  }
}