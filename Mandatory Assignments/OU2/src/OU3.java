import java.util.Scanner;

public class OU3 {

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    double b;
    double c;
    double a;
    double alpha;
    double beta;
    double sigma;

    //input sides of the triangle
    System.out.print(" Side A of the triangle: ");
    a = in.nextDouble();
    System.out.print(" Side B of the triangle: ");
    b = in.nextDouble();
    System.out.print(" Side C of the triangle: ");
    c = in.nextDouble();

    //input angles, Q: should these be calculated automatically w/o user input?
    System.out.print(" Angle between C and B: ");
    alpha = in.nextDouble();
    System.out.print(" Angle between B and A: ");
    beta = in.nextDouble();
    System.out.print(" Angle between A and C: ");
    sigma = in.nextDouble();
    System.out.println();

    //prints bisector lengths
    System.out.println(" Bisector Y: " + (Triangle.bisector(b, c, alpha)));
    System.out.println(" Bisector X: " + (Triangle.bisector(b, a, beta)));
    System.out.println(" Bisector Z: " + (Triangle.bisector(c, a, sigma)));
    System.out.println();

    //prints circumcircle radius
    System.out.println("Circumcircle radius: " + (Triangle.circumradius(a, b, c)));

    //prints incircle radius
    System.out.println("Incircle radius: " + (Triangle.inradius(a, b, c)));
    System.out.println();
  }
}
