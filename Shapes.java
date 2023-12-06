import java.util.*;

public class Shapes {
   public static void main(String[]  args) { // main
      Scanner input = new Scanner(System.in);
      int command = 0;
      
      System.out.println("SHAPES");
      System.out.println("Enter a command");
      String commandPrompt = input.next();
      
      if (commandPrompt.equals("quit")) { // initial quit command
         command = 5;
      }
         
      while (command != 5) { 
         command = 0;
         switch(commandPrompt) { // valid command
            case "square":
               square(input);
               command = 1;
               break;
            case "triangle":
               triangle(input);
               command = 2;
               break;
            case "rhombus":
               rhombus(input);
               command = 3;
               break;
            case "parallelogram":
               parallelogram(input);
               command = 4;
         }
         
         if (command != 1 && command !=2 && command !=3 && command !=4 && command !=5) { // invalid command
               System.out.println("Invalid input.");
               System.out.println();
         }
         
         System.out.println(); // enter command  row gain
         System.out.println("Enter a command.");
         commandPrompt = input.next();
         
         if (commandPrompt.equals("quit")) { // quit command
            command = 5;
         }
      }
  }
  
  public static void square(Scanner input) {
      System.out.println("Enter length");
      int length = input.nextInt();
      System.out.println("Enter width");
      int width = input.nextInt();
      System.out.println("Enter character");
      String character = input.next();
      for (int row  = 0; row < length; row++) {
         for (int column = 0; column < width; column++) {
            System.out.print(character + " ");
         }
         System.out.println();
      }
  }
  public static void triangle(Scanner input) {
      System.out.println("Enter base");
      int base = input.nextInt();
      System.out.println("Enter character");
      String character = input.next();
      for (int row = 0; row <= base; row++) { // row
         for (int space = 1; space <= base-row; space++) { // space
            System.out.print(" ");
         }
         for (int column = 1; column <= row ; column++) { // number
            System.out.print(character + " ");
         }
         System.out.println();
      }
  }
  
  public static void  rhombus(Scanner input) {
      System.out.println("Enter radius");
      int radius = input.nextInt();
      System.out.println("Enter character");
      String character = input.next();
      for (int row = -radius; row < radius; row++) { // row
         for (int space = 0; space < Math.abs(row); space++) { // space
            System.out.print(" ");
         }
         for (int column = 1; column <= Math.abs(radius) - Math.abs(row); column++) { // number
            System.out.print(character + " ");
         }
         System.out.println();
      }
  }
      
  public static void parallelogram(Scanner input) {
      System.out.println("Enter length");
      int length = input.nextInt();
      System.out.println("Enter width");
      int width = input.nextInt();
      System.out.println("Enter character");
      String character = input.next();
      for (int row = 0; row < length; row++) { // row
         for (int space = 1; space <= width-row; space++) { // space
            System.out.print(" ");
         }
         for (int column = 1; column <= width; column++) { // number
            System.out.print(character + " ");
         }
         System.out.println();
      }
  }
}
