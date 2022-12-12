package ru.stqa.pft.sandbox;

public class MyFirstProgramF {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Shamil");

    double l = 5; //переменная
    System.out.println("Площадь квадрата со стоороной " + l + " = " + area(l)); //l=5, area(len) = (5 * 5) 

    double a = 4;
    double b = 6;
    System.out.println("Площадь квадрата со стооронами " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double len)  //вычисляемая переменная
  {
    return len * len; //
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
