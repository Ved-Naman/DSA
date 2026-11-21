import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            int countOfZero = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    countOfZero++;
                }
            }

            boolean foundZero = false;
            int left = 0;
            int right = (int) n - 1;
            while (left < n && a[left] == 0) {
                left++;
            }
            while (right >= 0 && a[right] == 0) {
                right--;
            }
            for (int i = left; i <= right; i++) {
                if (a[i] == 0) {
                    foundZero = true;
                    break;
                }
            }
            if (countOfZero == n) {
                System.out.println(0);
            } else if (!foundZero) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        scanner.close();
    }
}

