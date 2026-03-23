package Module1;
import java.util.Scanner;

public class Credit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();
        if (isValid(number)) {
            System.out.println(number + " is valid");
        } else {
            System.out.println(number + " is not valid");
        }
        input.close();
    }
    
    public static boolean isValid(long number) {
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        int size = getSize(number);
        return (size >= 13 && size <= 16) &&
               (prefixMatched(number, 4) || prefixMatched(number, 5) || 
                prefixMatched(number, 37) || prefixMatched(number, 6)) &&
               (total % 10 == 0);
        }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        }
        return (number / 10) + (number % 10);
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return (d + "").length();
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

}
