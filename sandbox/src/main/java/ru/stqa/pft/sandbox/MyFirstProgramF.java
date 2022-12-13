package ru.stqa.pft.sandbox;

public class MyFirstProgramF {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Shamil");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стоороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со стооронами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point();
    p1.x = 5;
    p1.y = 10;
    Point p2 = new Point();
    p2.x = 10;
    p2.y = 15;

    distance(p1,p2);

  }

  public static void hello(String somebody){
    System.out.println("Hello " + somebody + "!");
  }

  public static void distance(Point p1, Point p2){
    double d = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    System.out.println("Расстояние между двумя точками: " + d);
  }
}

