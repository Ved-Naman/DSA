import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Track the number of requests handled by each server
        int[] count = new int[k];

        // Min-heap to store busy servers: stores int[] {freeTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // TreeSet to store available servers in sorted order
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int endTime = startTime + load[i];

            // Free up servers whose tasks have finished by the current arrival time
            while (!busy.isEmpty() && busy.peek()[0] <= startTime) {
                free.add(busy.poll()[1]);
            }

            // If all servers are busy, drop the request
            if (free.isEmpty()) {
                continue;
            }

            // Find the first available server >= (i % k)
            Integer server = free.ceiling(i % k);

            // If none found, wrap around to the first available server in the set
            if (server == null) {
                server = free.first();
            }

            // Assign the request to the chosen server
            count[server]++;
            busy.offer(new int[] {endTime, server});
            free.remove(server);
        }

        // Find the maximum number of requests handled by any server
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }

        // Collect all servers that handled the maximum number of requests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}