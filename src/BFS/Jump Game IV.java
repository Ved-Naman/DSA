class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1) return 0;

        Map<Integer, List<Integer>> teleporters = new HashMap<>();
        for (int i = 0; i < n; i++) {
            teleporters.putIfAbsent(arr[i], new ArrayList<>());
            teleporters.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    return steps;
                }

                int[] walkingDoors = {curr + 1, curr - 1};
                for (int nextRoom : walkingDoors) {
                    if (nextRoom >= 0 && nextRoom < n && !visited[nextRoom]) {
                        visited[nextRoom] = true;
                        queue.add(nextRoom);
                    }
                }

                List<Integer> teleportRooms = teleporters.get(arr[curr]);
                for (int nextRoom : teleportRooms) {
                    if (!visited[nextRoom]) {
                        visited[nextRoom] = true;
                        queue.add(nextRoom);
                    }
                }

                teleporters.get(arr[curr]).clear();
            }

            steps++;
        }

        return -1;
    }
}
