import java.util.Scanner;

public class MochaAndMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = sc.nextLong();
            for (int i = 1; i < n; i++) {
                ans &= sc.nextLong();
            }
            System.out.println(ans);
        }
        sc.close();
    }
}