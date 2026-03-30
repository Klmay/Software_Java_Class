package Module2;
import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three sides of your triangle (any number): ");
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();

        System.out.print("Pick a color (any color): ");
        String color = input.next();

        System.out.print("Is the triangle filled in with your color? (type true or false) ");
        boolean filled = input.nextBoolean();

        Triangle triangle = new Triangle(s1, s2, s3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("\n--- Your Triangle ---");
        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Is filled: " + triangle.isFilled());

        input.close();
    }
    
}