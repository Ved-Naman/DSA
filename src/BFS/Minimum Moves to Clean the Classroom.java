class Solution {
    class State {
        int r, c, energy, mask, steps;
        State(int r, int c, int energy, int mask, int steps) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterIds = new int[m][n];
        int startR = 0, startC = 0, totalLitter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litterIds[i][j] = totalLitter++;
                }
            }
        }

        if (totalLitter == 0) return 0;

        int targetMask = (1 << totalLitter) - 1;
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << totalLitter];

        java.util.Queue<State> queue = new java.util.ArrayDeque<>();
        queue.offer(new State(startR, startC, energy, 0, 0));
        visited[startR][startC][energy][0] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.mask == targetMask) {
                return curr.steps;
            }

            if (curr.energy == 0) {
                continue;
            }

            for (int[] dir : dirs) {
                int nextR = curr.r + dir[0];
                int nextC = curr.c + dir[1];

                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                    char nextCell = classroom[nextR].charAt(nextC);

                    if (nextCell == 'X') continue;

                    int nextEnergy = curr.energy - 1;
                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    }

                    int nextMask = curr.mask;
                    if (nextCell == 'L') {
                        nextMask |= (1 << litterIds[nextR][nextC]);
                    }

                    if (!visited[nextR][nextC][nextEnergy][nextMask]) {
                        visited[nextR][nextC][nextEnergy][nextMask] = true;
                        queue.offer(new State(nextR, nextC, nextEnergy, nextMask, curr.steps + 1));
                    }
                }
            }
        }

        return -1;
    }
}