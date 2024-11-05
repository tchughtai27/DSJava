/*
 * Talha Chughtai ATCS
 * HW11 PartB
 * 11/4
 */
public class PartB {
    public static double mystery(double x, double y)
{
   double result = (x + y) / (y - x); //(3+2) / (3-2) = 5 / -1 = -5
   return result;
}
public static void main(String[] args) {
    double x = 3;
    double y = 2;
    double mystery = mystery(x, y);
    System.out.println(mystery); //check to ensure im correct

}
}
