class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                mid = (char) (i + 'a');
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int len = n / 2;

        int[] temp = halfFreq.clone();
        boolean canMatch = true;
        for (int j = 0; j < len; j++) {
            char c = target.charAt(j);
            if (temp[c - 'a'] > 0) {
                temp[c - 'a']--;
            } else {
                canMatch = false;
                break;
            }
        }

        if (canMatch) {
            StringBuilder L = new StringBuilder(target.substring(0, len));
            StringBuilder P = new StringBuilder(L);
            if (n % 2 != 0) {
                P.append(mid);
            }
            for (int j = L.length() - 1; j >= 0; j--) {
                P.append(L.charAt(j));
            }
            if (P.toString().compareTo(target) > 0) {
                return P.toString();
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            temp = halfFreq.clone();
            canMatch = true;
            for (int j = 0; j < i; j++) {
                char c = target.charAt(j);
                if (temp[c - 'a'] > 0) {
                    temp[c - 'a']--;
                } else {
                    canMatch = false;
                    break;
                }
            }

            if (!canMatch) {
                continue;
            }

            char reqChar = target.charAt(i);
            char bestC = 0;
            for (int j = reqChar - 'a' + 1; j < 26; j++) {
                if (temp[j] > 0) {
                    bestC = (char) (j + 'a');
                    break;
                }
            }

            if (bestC != 0) {
                StringBuilder L = new StringBuilder();
                L.append(target.substring(0, i));
                L.append(bestC);
                temp[bestC - 'a']--;

                for (int j = 0; j < 26; j++) {
                    while (temp[j] > 0) {
                        L.append((char) (j + 'a'));
                        temp[j]--;
                    }
                }

                StringBuilder P = new StringBuilder(L);
                if (n % 2 != 0) {
                    P.append(mid);
                }
                for (int j = L.length() - 1; j >= 0; j--) {
                    P.append(L.charAt(j));
                }
                return P.toString();
            }
        }

        return "";
    }
}