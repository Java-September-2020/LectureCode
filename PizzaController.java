public class PizzaController {
  // Entry Point Method
  public static void main(String[] args) {
    // Creating an Object using the empty constructor in our Pizza Class. This will
    // create an object with no parameters that we will have to use the SET methods
    // to populate.
    Pizza cheesePizza = new Pizza(); // Stand Alone Object
    // cheesePizza.setTopping = new String[] { "cheese" };
    // cheesePizza.setSauce = "marinara";
    // cheesePizza.setSize = 'L';
    // cheesePizza.setPrice = 14.99;
    // cheesePizza.displayPizza();

    // Creating an Object using the constructor that allows the user to set a price.
    Pizza pepperoniPizza = new Pizza("white sauce", new String[] { "pepperoni", "cheese" }, 'L', 14.99);
    System.out.println(pepperoniPizza.getSauce());
    pepperoniPizza.eatASlice(3);
    System.out.println(pepperoniPizza.getSlices());

    // Creating an Object using the constructor that allows the user to create a
    // pizza with default parameters put in.
    Pizza vegeterianPizza = new Pizza("marinara", new String[] { "mushrooms", "peppers" }, 'L');
    System.out.println(vegeterianPizza.getPrice());
    System.out.println(vegeterianPizza.getSlices());

    // Example of method overloading, Java knows which method to call based on the
    // parameters we are inputting.
    vegeterianPizza.eatASlice();
    vegeterianPizza.eatASlice(4);
  }
}