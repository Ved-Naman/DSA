import java.util.Scanner;

public class ExcitingBets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            if (b > a) {
                long temp = a;
                a = b;
                b = temp;
            }

            if (a == b) {
                System.out.println("0 0");
            } else {
                long gcd = a - b;
                long moves = Math.min(b % gcd, gcd - b % gcd);
                System.out.println(gcd + " " + moves);
            }
        }
        scanner.close();
    }
}