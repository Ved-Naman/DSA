import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            int n = scanner.nextInt();
            long[] x = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextLong();
            }

            long maxtime = b;
            for (int i = 0; i < n; i++) {
                maxtime += Math.min(x[i], a - 1);
            }
            System.out.println(maxtime);
        }
        scanner.close();
    }
}

