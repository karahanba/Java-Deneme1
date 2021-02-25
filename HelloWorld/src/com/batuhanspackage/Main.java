package com.batuhanspackage;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.println("Hello World");
        //String userstatus = "gold"; // gold,silver,affiliate,customerfor2year
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter total bill value, if not integer use coma...");
            double billValue = scanner.nextDouble();

            System.out.println("Enter number for user status; '1' Gold, '2' Silver, '3' Affiliate, '4' Not Defined");
            int userStatus = scanner.nextInt();
            //System.out.println("you selected "+ userStatus);
            int extraDiscount;
            double percentageDiscount = 0;

            System.out.println("Is product a phone?:boolean, Type 'True' or 'False'");
            boolean productPhone = scanner.nextBoolean();

            if (userStatus == 1 && !productPhone) { // if userStatus is Gold and product is not a phone
                percentageDiscount = billValue * 30 / 100;

            }
            else if (userStatus == 2 && !productPhone) { // if userStatus is Silver and product is not a phone
                percentageDiscount = billValue * 20 / 100;
            }
            else if (userStatus == 3 && !productPhone) { // if userStatus is Affiliate and product is not a phone
                percentageDiscount = billValue * 10 / 100;
            }
            else if (userStatus == 4 && !productPhone) { // if userStatus is Not Defined and product is not a phone
                System.out.println("Is user a customer over 2 years?:Type Y/N");
                String customerOvertwo = scanner.next();
                customerOvertwo = customerOvertwo.toUpperCase();

                if (customerOvertwo.equals("Y")) { // if user is a Customer for over 2 years
                    System.out.println("Yes");
                    percentageDiscount = billValue * 5 / 100;
                    System.out.println(billValue);
                }
                else if (customerOvertwo.equals("N")) {
                    System.out.println("No");
                    System.out.println(billValue);
                }
            }
            else if (userStatus > 4 | userStatus == 0) {
                /*System.out.println("False Entry!!! userStatus values vary between 1 and 4. Please try again");
                System.exit(0);
                 */
                throw new Exception("Entry is not valid!!! userStatus values must be between 1 and 4. ");
            }
            else {
                System.out.println("There can be no Percentage Discount on phones... ");
            }

            billValue = billValue - percentageDiscount;
            extraDiscount = 5 * (int) (billValue / 200); // 5$ discount for every 200$
            billValue = billValue - extraDiscount;
            System.out.println("percentage discount = " + percentageDiscount + "  ,  extra discount = " + extraDiscount);
            System.out.println("Bill value = " + billValue);
            }
        /*
        catch (InputMismatchException e){System.out.println(e);}
        catch (ArithmeticException e){System.out.println("Arithmetic Exception occurs");}
        */
        catch (Exception e){System.out.println(e);}


    }
}