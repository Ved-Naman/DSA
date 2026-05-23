class Solution {
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        List<Integer> x = new ArrayList<>();

        for (String word : words) {
            if (Character.isDigit(word.charAt(0))) {
                x.add(Integer.parseInt(word));
            }
        }

        for (int i = 0; i < x.size() - 1; i++) {
            if (x.get(i) >= x.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}