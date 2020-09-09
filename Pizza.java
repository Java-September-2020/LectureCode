import java.util.Arrays;

public class Pizza {
  // Access Modifiers
  private String sauce;
  private String[] toppings;
  private char size;
  private double price;
  private int slices;

  // Constructor
  public Pizza(String sauce, String[] toppings, char size, double price) {
    this.sauce = sauce;
    this.toppings = toppings;
    this.size = size;
    this.price = price;
    this.slices = 8;
  }

  // Method Overloading
  public Pizza(String sauce, String[] toppings, char size) {
    this.sauce = sauce;
    this.toppings = toppings;
    this.size = size;
    this.price = 20.00;
    this.slices = 10;
  }

  public Pizza() {

  }

  // Things we can do with the pizza
  public void displayPizza() {
    System.out.printf("This is a pizza with %s sauce, and with %s toppings, that costs $%.2f dollars\n", this.sauce,
        Arrays.toString(this.toppings), this.price);

  }

  // eat a slice
  public void eatASlice(int slices) {
    System.out.printf("You have eaten %d slices", slices);
    this.slices -= slices;
    System.out.println("The pizza now has " + this.slices + " slices left");
  }

  // eat a slice with method overloading. Java will know which method to use based
  // on the number of parameters that are input.
  public void eatASlice() {
    System.out.printf("You have eaten 1 slice of pizza");
    this.slices -= 1;
    System.out.println("The pizza now has " + this.slices + " slices left");
  }

  // Example on how an object can interact with another object. By importing
  // "otherPizza" into here, we now have access to all the otherObject's
  // attributes and can modify them as we please
  public void pizzaFight(Pizza otherPizza) {
    otherPizza.setSlices(otherPizza.getSlices() - 1);
    System.out.println(
        Arrays.toString(this.toppings) + " pizza just cut 1 slice from " + Arrays.toString(otherPizza.toppings));
    System.out.println("Other pizza now has " + otherPizza.getSlices());
  }

  // Getters
  public int getSlices() {
    return this.slices;
  }

  public String getSauce() {
    return this.sauce;
  }

  public String getToppings() {
    return Arrays.toString(this.toppings);
  }

  public char getSize() {
    return this.size;
  }

  public double getPrice() {
    return this.price;
  }

  // Setters
  public void setPrice(double price) {
    this.price = price;
  }

  // The point of having private properties and using public getters and setters
  // to access them is being able to add an extra layer of security to what the
  // user is allowed to do. Here we would deny a user from being able to set the
  // sauce to blank. Essentially making it a required field.
  public void setSauce(String sauce) {
    if (sauce.equals("")) {
      System.out.println("Sauce field cannot be empty");
      return;
    }
    this.sauce = sauce;
  }

  public void setSize(char size) {
    this.size = size;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

}