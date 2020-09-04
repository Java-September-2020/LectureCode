import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // Array
    String[] people = { "Matthew", "Jeremy", "Edgar" };
    String[] newPeople = new String[10];
    Object[] myObjectArr = { "matthew", 13, 'c' };

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }
    // Way to print out values from the Array
    System.out.println(Arrays.toString(numbers));

    // ArrayLists
    ArrayList<String> numbersSpelledOut = new ArrayList<String>();
    numbersSpelledOut.add("one"); // index 0
    numbersSpelledOut.add("two"); // index 1
    numbersSpelledOut.add("three"); // index 2
    numbersSpelledOut.add("four"); // index 3

    System.out.println(numbersSpelledOut.get(1));

    for (int i = 0; i < numbersSpelledOut.size(); i++) {
      // System.out.println(numbersSpelledOut.get(i));
    }

    // For Each Loop
    for (String num : numbersSpelledOut) {
      // System.out.println(num);
    }

    // Hash Map
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Edgar", "Video Games");
    ourHobbies.put("Justin", "Making Wine");
    ourHobbies.put("Jeremy", "Cryptocurrency");
    ourHobbies.put("Frank", "Sleep");
    ourHobbies.put("Ozair", "Traveling");
    ourHobbies.put("Taylor", "Running");
    ourHobbies.put("Matt", "Photography");
    ourHobbies.put("Zach", "WebFun");

    System.out.println(ourHobbies.get("Edgar"));

    for (String name : ourHobbies.keySet()) {
      // System.out.println(name);
    }

    for (String name : ourHobbies.values()) {
      // System.out.println(name);
    }

    for (HashMap.Entry<String, String> nameHobbies : ourHobbies.entrySet()) {
      System.out.println("Key: " + nameHobbies.getKey() + ", Value: " + nameHobbies.getValue());
    }

    // Methods
    // Get Max Value;
    int[] someNums = { 1, 13, 33, 19, 102, 40, 9 };
    // System.out.println(getMaxValue(someNums));

    for (int i = 0; i <= someNums.length; i++) {
      try {
        System.out.println(someNums[i]);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

  }

  public static int getMaxValue(int[] numbers) {
    // Create A Max Value Variable To Hold the First of the Array
    // Create a For Loop, Loop the Array
    // Compare if the iterator value is greater than max value, replace max value
    // with new value
    // return max value
    int greatestValue = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > greatestValue) {
        greatestValue = numbers[i];
      }
    }
    return greatestValue;
  }
}