import java.util.Scanner; //Scanner was not imported. 

public class PartA
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("What is your first name? ");
      String input = in.next();
      System.out.println("Hello, " + input);
      System.out.print("How old are you? ");
      int input1 = in.nextInt(); //this variable was already declared as a String. This is a duplicate local variable input. 
        //changed it to input1
      input1++; //changed to input 1 instead.
      System.out.println("Next year, you will be " + input1); //changed to input1 to match. 
   }
}
