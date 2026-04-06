package Module3;
import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) {
    // Prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.print("Enter rational r1 with numerator and denominator seperated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.print("Enter rational r2 with numerator and denominator seperated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    input.close();

    RationalUsingBigInteger r1 = new RationalUsingBigInteger(
      new BigInteger(n1), new BigInteger(d1));
    RationalUsingBigInteger r2 = new RationalUsingBigInteger(
      new BigInteger(n2), new BigInteger(d2));

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

// Name the revised Rational class RationalUsingBigInteger 
class RationalUsingBigInteger extends Number 
    implements Comparable<RationalUsingBigInteger> {
  // Data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  public RationalUsingBigInteger() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }
  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);

    this.numerator = (denominator.signum() > 0 ? BigInteger.ONE : new BigInteger("-1"))
      .multiply(numerator).divide(gcd);
    this.denominator = denominator.abs().divide(gcd);
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public RationalUsingBigInteger add(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
      .add(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger subtract(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
      .subtract(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger multiply(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger divide(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.getNumerator());
    return new RationalUsingBigInteger(n, d);
  }

  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((RationalUsingBigInteger)(other))).getNumerator().equals(BigInteger.ZERO))
      return true;
    else
      return false;
  }

  @Override
  public int intValue() {
    return (int)doubleValue();
  }

  @Override
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.divide(denominator).doubleValue();
  }

  @Override
  public long longValue() {
    return (long)doubleValue();
  }

  @Override
  public int compareTo(RationalUsingBigInteger o) {
    if (this.subtract(o).getNumerator().signum() > 0)
      return 1;
    else if (this.subtract(o).getNumerator().signum() < 0)
      return -1;
    else
      return 0;
  }

}
