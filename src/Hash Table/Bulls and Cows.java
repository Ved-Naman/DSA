class Solution {
    public String getHint(String secret, String guess) {
        int x = 0;
        int y = 0;

        int[] secretBucket = new int[10];
        int[] guessBucket = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                x++;
            } else {
                secretBucket[s - '0']++;
                guessBucket[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            y += Math.min(secretBucket[i], guessBucket[i]);
        }

        return x + "A" + y + "B";
    }
}