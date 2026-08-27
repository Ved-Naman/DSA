class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String bestAns = "";

        for (int i = 0; i <= target.length(); i++) {
            if (i == target.length()) {
                if (s.length() > target.length()) {
                    StringBuilder sb = new StringBuilder(target);
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            sb.append((char) (j + 'a'));
                            freq[j]--;
                        }
                    }
                    bestAns = sb.toString();
                }
                break;
            }

            char t = target.charAt(i);
            char bestC = 0;

            for (int j = t - 'a' + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    bestC = (char) (j + 'a');
                    break;
                }
            }

            if (bestC != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append(bestC);

                int[] tempFreq = freq.clone();
                tempFreq[bestC - 'a']--;

                for (int j = 0; j < 26; j++) {
                    while (tempFreq[j] > 0) {
                        sb.append((char) (j + 'a'));
                        tempFreq[j]--;
                    }
                }
                bestAns = sb.toString();
            }

            if (freq[t - 'a'] > 0) {
                freq[t - 'a']--;
            } else {
                break;
            }
        }

        return bestAns;
    }
}