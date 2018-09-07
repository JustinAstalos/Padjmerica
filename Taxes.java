import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Taxes
{  
  public static void main ( String[] args )  
  {
    int income;
    Scanner scan = new Scanner( System.in );
    System.out.println("Enter your annual income:");
    income = scan.nextInt();

    int age;
    double ageDiscount = 0;
    System.out.println("Enter your age:");
    age = scan.nextInt();
    //These are all the inverses of the percent so they can be multiplied by the tax
    if(age <= 15)
    {
        ageDiscount = 0.5;
    }
    else if(age > 15 && age <= 21)
    {
        ageDiscount = 0.75;
    }
    else if(age > 21 && age <= 63)
    {
        ageDiscount = 1;
    }
    else if(age > 63 && age <= 72)
    {
        ageDiscount = 0.67;
    }
    else if(age > 72 && age <= 80)
    {
        ageDiscount = 0.34;
    }
    else if(age > 80)
    {
        ageDiscount = 0;
    }

    int dependents;
    int dependentBonus;
    System.out.println("Enter the number of child dependents you have:");
    dependents = scan.nextInt();
    if (dependents == 1 || dependents == 3)
    {
        dependentBonus = 1000;
    }
    else if (dependents >= 3)
    {
        dependentBonus = dependents*500;
    }
    else
    {
        dependentBonus = 0;
    }

    double taxes = 0;
    if (income < 10000)
    {
        taxes = (0-dependentBonus)*ageDiscount;
    }
    else if (income >= 10000 && income < 25000)
    {
        taxes = (income-10000)*0.1;
        if (taxes < 500)
        {
            taxes = 500;
        }
    }
    else if (income >= 25000 && income < 75000)
    {
        taxes = 1500 + ((income-25000)*0.2);
        taxes = taxes-dependentBonus;
        taxes = taxes*ageDiscount;
        if (taxes < 5000)
        {
            taxes = 5000;
        }
    }
    else if (income >= 75000 && income < 250000)
    {
        taxes = 11500 + (income-75000)*0.3;
        taxes = taxes-dependentBonus;
        taxes = taxes*ageDiscount;
        if (taxes < 10000)
        {
            taxes = 1000;
        }
    }
    else if (income >= 250000)
    {
        taxes = 64000 + (income-10000)*0.1;
        taxes = taxes-dependentBonus;
        taxes = taxes*ageDiscount;
        if (taxes < 500)
        {
            taxes = 500;
        }

    }
    System.out.println("You will pay $"+taxes+" in taxes");
  }
}
