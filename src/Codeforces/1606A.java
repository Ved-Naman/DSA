import java.util.Scanner;

public class ABBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String s = scanner.nextLine();
            int n = s.length();
            if (s.charAt(0) != s.charAt(n - 1)) {
                s = s.substring(0, n - 1) + s.charAt(0);
            }
            System.out.println(s);
        }
        scanner.close();
    }
}