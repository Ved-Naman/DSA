import java.util.Scanner;

public class OddDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();

            while (n % 2 == 0) {
                n /= 2;
            }

            if (n > 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}