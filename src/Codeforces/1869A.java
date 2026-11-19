import java.util.Scanner;

public class MakeItZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            if (n % 2 == 0) {
                System.out.println(2);
                System.out.println(1 + " " + n);
                System.out.println(1 + " " + n);
            } else {
                System.out.println(4);
                System.out.println(1 + " " + (n - 1));
                System.out.println(1 + " " + (n - 1));
                System.out.println((n - 1) + " " + n);
                System.out.println((n - 1) + " " + n);
            }
        }
        scanner.close();
    }
}