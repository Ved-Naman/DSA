import java.util.Scanner;

public class AvtoBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();

        while (t-- > 0) {
            long n = scanner.nextLong();
            if (n < 4 || n % 2 == 1) {
                System.out.println(-1);
            } else {
                long maxBuses = n / 4;
                long minBuses = (n + 5) / 6;
                System.out.println(minBuses + " " + maxBuses);
            }
        }

        scanner.close();
    }
}
