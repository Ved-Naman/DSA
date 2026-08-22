import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int maxGap = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(position, m, mid)) {
                maxGap = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxGap;
    }

    private boolean canPlace(int[] position, int m, int gap) {
        int ballsPlaced = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= gap) {
                ballsPlaced++;
                lastPosition = position[i];

                if (ballsPlaced == m) {
                    return true;
                }
            }
        }
        return false;
    }
}