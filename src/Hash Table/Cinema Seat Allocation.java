class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, RowState> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new RowState());
            map.get(row).reserveSeat(col);
        }

        int maxFamilies = (n - map.size()) * 2;

        for (RowState state : map.values()) {
            if (state.leftSafe && state.rightSafe) {
                maxFamilies += 2;
            } else if (state.leftSafe || state.midSafe || state.rightSafe) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }

    class RowState {
        boolean leftSafe = true;
        boolean midSafe = true;
        boolean rightSafe = true;

        public void reserveSeat(int col) {
            if (col >= 2 && col <= 5) {
                leftSafe = false;
            }
            if (col >= 4 && col <= 7) {
                midSafe = false;
            }
            if (col >= 6 && col <= 9) {
                rightSafe = false;
            }
        }
    }
}