public class FizzBuzz {

  // Method to calculate logic for fizzBuzz, if a number is divisible. and return
  // the value
  public String fizzBuzz(int val) {
    if (val % 3 == 0 && val % 5 == 0) {
      return "FizzBuzz";
    } else if (val % 3 == 0) {
      return "Fizz";
    } else if (val % 5 == 0) {
      return "Buzz";
    } else {
      return Integer.toString(val);
    }
  }

  // Method to loop to 100 and feed the number of the loop to our helper method
  public void fizzBuzzCounter() {
    for (int i = 1; i <= 100; i++) {
      String result = fizzBuzz(i);
      System.out.println("Number: " + i + " - " + " Result: " + result);
    }
  }

  // Method that can run without an object being created
  public static void sayHello() {
    System.out.println("Hello!!!!!");
  }
}