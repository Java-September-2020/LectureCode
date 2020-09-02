public class FirstProgram {
  // Entry Point Method
  public static void main(String[] args) {
    // Variables
    // Primitives
    byte myByte = 100; // Stores whole numbers from -128 to 127
    short myShort = 30000; // Stores whole numbers from -32,768 to 32,767
    int myInt = 1000000; // Stores whole numbers from -2,147,483,648 to 2,147,483,647
    long myLong = 8488; // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

    float myFloat = 3.14f; // stores fractional numbers, sufficient for storing 6 to 7 decimal places.
    double myDouble = 3.123454837; // Stores fractional numbers, sufficient for storing up to 15 deimal digits

    boolean myBool = true; // Stores true and false
    char myChar = 'c';

    Integer myWrapperInt = 1000000; // Same as int, but with methods attached.
    Character myWrapperChar = 'c';

    // Strings
    String myString = "Java September 2020";
    String bootcamp = "Java";
    String bootCamp = "September";
    String bootCAMP = "2020";

    System.out.println(bootcamp + " " + bootCamp + " " + bootCAMP);
    System.out.printf("My name is %n", "Matt");

    // Operators and Conditionals
    System.out.println(2 == 2);
    String matt = "Matt";
    String jeremy = "Matt";
    System.out.println(matt.equals(jeremy));

    int num = 6;
    if (num % 2 != 0) {
      System.out.println("Number is Odd");
    } else {
      System.out.println("Number is not odd");
    }

    // Loops
    // While
    int i = 0;
    while (i < 4) {
      System.out.println(i);
      i++;
    }

    // For Loop
    for (int counter = 0; i < 4; i++) {
      System.out.println(counter);
    }

    // Methods
    System.out.println(sayHello("Justin"));
    printNum();

    // A Method with a return has to be wrapped with a System.out.println to display
    // the return value. Think of a return as setting the method itself equal to the
    // return statement.
    // A Method that just prints something to the console, returns nothing, so it
    // must be used with a void and doesn't need to be wrapped in System.out.println
  }

  public static String sayHello(String name) {
    return "Hello" + name;
  }

  public static void printNum() {
    System.out.println("2");
  }
}