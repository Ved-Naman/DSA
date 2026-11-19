import java.util.Scanner;

public class LongestDivisorsInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long i = 1;
            while (n % i == 0) {
                i++;
            }
            System.out.println(i - 1);
        }
        scanner.close();
    }
}