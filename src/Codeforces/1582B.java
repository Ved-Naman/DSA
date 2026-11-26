import java.util.Scanner;

public class LuntikAndSubsequences {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        long t = sc.nextLong();
        while(t-->0){
            long n = sc.nextLong();
            long[] a = new long [(int) n ];
            for(int i =0; i< n; i++){
                a[i]= sc.nextLong();
            }
            long zero = 0;
            long one = 0;
            for(int i=0; i<n; i++){
                if(a[i]==0){
                    zero++;
                }
                if(a[i]==1){
                    one++;
                }
            }
            long ways = (long) Math.pow(2, zero) * one;
            System.out.println(ways);
        }
        sc.close();
    }
}