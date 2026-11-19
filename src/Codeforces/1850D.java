import java.util.*;

public class BalancedRound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            Arrays.sort(a);

            long counter = 1;
            long largestLength = 1;

            for (int i = 1; i < n; i++) {

                if (a[i] - a[i - 1] <= k) {
                    counter++;
                } else {
                    counter = 1;
                }

                largestLength = Math.max(largestLength,counter);
            }

            System.out.println(n -largestLength);
        }
        scanner.close();
    }
}

