import java.util.Scanner;

public class BadBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                long n = scanner.nextLong();
                long m = scanner.nextLong();
                long i = scanner.nextLong();
                long j = scanner.nextLong();

                System.out.println("1 1 " + n + " " + m);
            }
        }
        scanner.close();
    }
}