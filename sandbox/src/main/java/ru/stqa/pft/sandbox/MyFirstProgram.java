package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    //Переменная String - строка
    String somebody = "world";
    System.out.println("Hello, " + somebody + "!");

    /* Переменные
    int - целочисленные
    double - число с плавующей точкой (число двойной точности) */
    double l = 8;
    double s = l * l;
    System.out.println("Площадь квадрата со стороной " + l + " = " + s);
  }

}