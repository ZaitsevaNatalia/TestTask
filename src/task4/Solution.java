package task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* We moved method  amountFor() into class Rental because it is native method of class Rental, which get object Rental, uses gets of this class and return private field rental. And if we do not move this method we can not call it in other classes, for example in class Client or class Shop  */

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the name of our customer:");
        String name = reader.readLine();

        System.out.println("Input a number of days:");
        String days = reader.readLine();
        int d = Integer.parseInt(days);

        System.out.println("Input a kind (from 1 to 3):");
        String kind = reader.readLine();
        int k = Integer.parseInt(kind);

        System.out.println("Input a basePrice:");
        String basePrice = reader.readLine();
        int b = Integer.parseInt(basePrice);

        Customer customer = new Customer(name);
        Rental rental = new Rental(k, d, b);
        double rentalCustomer = rental.getRental();

        System.out.print("For " + name + " rental equals " + rentalCustomer + " $");

    }
}