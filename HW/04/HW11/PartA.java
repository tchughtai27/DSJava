/*
 * Talha Chughtai ATCS
 * HW11 PartA
 * 11/4
 */
public class PartA {
public static void main(String[] args)
{
   double len = 2;
   double result = cubeVolume(len);
   System.out.println(result);
   len = 10;
   result = cubeVolume(len);
   System.out.println(result);
}

public static double cubeVolume(double sideLength)
{   
   double volume = sideLength * sideLength * sideLength;
   return volume;
}

}



/* Step        Len      SideLength        Volume         Result            Output     
 * 1           2           -                 -              -                 -
 * 2           2           2                 -              -                 -
 * 3           2           2                 8              8                 -
 * 4           2           -                 -              8                 8.0
 * 5           10          -                 -              8                 -
 * 6           10          10                -              -                 -
 * 7           10          10                1000           1000              -
 * 8           10          -                 -              1000              1000.0
 */         