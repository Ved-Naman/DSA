import java.util.Scanner;

public class MakeItIncreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            long ans = 0;
            for (int i = n - 2; i >= 0; i--) {
                while (a[i] >= a[i + 1]) {
                    ans++;
                    a[i] /= 2;
                    if (a[i] == 0) {
                        break;
                    }
                }
                if (a[i] == 0 && a[i + 1] == 0) {
                    ans = -1;
                    break;
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}

