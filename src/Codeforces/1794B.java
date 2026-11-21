import java.util.Scanner;

public class NotDividing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    a[i]++;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (a[i + 1] % a[i] == 0) {
                    a[i + 1]++;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

}
