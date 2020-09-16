package animal;

import java.util.ArrayList;

public class AnimalController {
	// Entry Point Method
	public static void main(String[] args) {
		Animal dog = new Animal(10, "dog", "buster", 23, "black", 100);
		System.out.println("Eclipse Is Great");
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		myAnimals.add(dog);
		
		for(Animal a : myAnimals) {
			System.out.println(a.getSpecies());
		}
	}
}
