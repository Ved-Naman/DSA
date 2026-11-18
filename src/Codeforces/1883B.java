import java.util.Scanner;

public class Chemistry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            String s = scanner.next();
            int[] freqc = new int[26];
            for (int i = 0; i < n; i++) {
                freqc[s.charAt(i) - 'a']++;
            }

            long odd = 0;
            for (int i = 0; i < 26; i++) {
                odd += freqc[i] % 2;
            }

            if (odd>k+1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        scanner.close();
    }
}