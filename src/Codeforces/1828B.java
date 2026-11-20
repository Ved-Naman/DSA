import java.util.*;

public class PermutationSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int k = Math.abs(a[0] - 1);
            for (int i = 1; i < n; i++) {
                k = gcd(k, Math.abs(a[i] - (i + 1)));
            }
            System.out.println(k);
        }
        scanner.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

