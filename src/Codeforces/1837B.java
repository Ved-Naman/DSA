import java.util.Scanner;

public class ComparisonString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            String s = scanner.next();

            long Length = 1;
            long currLength = 1;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currLength++;
                } else {
                    Length = Math.max(Length, currLength);
                    currLength = 1;
                }
            }

            Length = Math.max(Length, currLength);

            System.out.println(Length + 1);
        }
        scanner.close();
    }

}
