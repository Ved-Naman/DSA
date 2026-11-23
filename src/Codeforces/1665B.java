import java.util.*;

public class ArrayCloningTechnique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            Map<Long, Long> frequencyMap = new HashMap<>();
            for (long value : a) {
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0L) + 1);
            }
            long currentHighestFreq = 0;
            for (long freq : frequencyMap.values()) {
                currentHighestFreq = Math.max(currentHighestFreq, freq);
            }
            long operations = 0;
            while (currentHighestFreq < n) { ]
                operations++;
                if (currentHighestFreq * 2 <= n) {
                    operations += currentHighestFreq;
                    currentHighestFreq *= 2;
                } else {
                    operations += n - currentHighestFreq;
                    currentHighestFreq = n;
                }
            }

            System.out.println(operations);
        }
        scanner.close();
    }
}
