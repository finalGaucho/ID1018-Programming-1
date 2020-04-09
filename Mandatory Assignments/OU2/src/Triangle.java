import java.util.Scanner;

public class Triangle {

  //bisector method
  public static double bisector(double b, double c, double alpha)
  {
    double p = 2 * b * c * Math.cos(alpha / 2);
    double bis = p / (b + c);
    return bis;
  }

  //circumradius method
  public static double circumradius(double a, double b, double c)
  {
    double cr = Math.sqrt((Math.pow(a, 2))*(Math.pow(b, 2))*(Math.pow(c, 2)) /
                ((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c)));
    return cr;

  }

  //inradius method
  public static double inradius(double a, double b, double c)
  {
    double ir = Math.sqrt(((-a + b + c) * (a - b + c) * (a + b - c)) /
                (4*(a + b + c)));
    return ir;
  }

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
    System.out.println(" Bisector Y: " + (bisector(b, c, alpha)));
    System.out.println(" Bisector X: " + (bisector(b, a, beta)));
    System.out.println(" Bisector Z: " + (bisector(c, a, sigma)));
    System.out.println();

    //prints circumcircle radius
    System.out.println("Circumcircle radius: " + (circumradius(a, b, c)));

    //prints incircle radius
    System.out.println("Incircle radius: " + (inradius(a, b, c)));
    System.out.println();
  }
}
