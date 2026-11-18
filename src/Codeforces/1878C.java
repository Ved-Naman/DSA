import java.util.Scanner;

public class VasilijeInCacak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long x = scanner.nextLong();
            long minimumSum = (k * (k + 1)) / 2;
            long maximumSum = (n * (n + 1)) / 2 - ((n - k) * (n - k + 1)) / 2;
            if (x >= minimumSum && x <= maximumSum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

}