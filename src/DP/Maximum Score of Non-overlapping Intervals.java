class Solution {
    class Interval {
        int start, end, weight, id;
        Interval(int start, int end, int weight, int id) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.id = id;
        }
    }

    class State {
        long score;
        int[] indices;
        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(java.util.List<java.util.List<Integer>> intervals_input) {
        int n = intervals_input.size();
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(
                    intervals_input.get(i).get(0),
                    intervals_input.get(i).get(1),
                    intervals_input.get(i).get(2),
                    i
            );
        }

        java.util.Arrays.sort(intervals, (a, b) -> {
            if (a.start != b.start) return Integer.compare(a.start, b.start);
            if (a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.id, b.id);
        });

        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new int[0]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int left = i + 1, right = n - 1, next_j = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (intervals[mid].start > intervals[i].end) {
                    next_j = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];

                State nextState = dp[next_j][k - 1];
                long takeScore = intervals[i].weight + nextState.score;

                int[] nextIndices = nextState.indices;
                int[] newIndices = new int[nextIndices.length + 1];
                int newId = intervals[i].id;
                int pos = 0;

                while (pos < nextIndices.length && nextIndices[pos] < newId) {
                    newIndices[pos] = nextIndices[pos];
                    pos++;
                }
                newIndices[pos] = newId;
                while (pos < nextIndices.length) {
                    newIndices[pos + 1] = nextIndices[pos];
                    pos++;
                }

                State take = new State(takeScore, newIndices);

                if (isBetter(take, skip)) {
                    dp[i][k] = take;
                } else {
                    dp[i][k] = skip;
                }
            }
        }

        return dp[0][4].indices;
    }

    private boolean isBetter(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score;
        }

        for (int i = 0; i < Math.min(a.indices.length, b.indices.length); i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i];
            }
        }

        return a.indices.length < b.indices.length;
    }
}