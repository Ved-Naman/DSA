class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for(String t : timePoints){
            int h = Integer.parseInt(t.substring(0,2));
            int m = Integer.parseInt(t.substring(3,5));
            minutes.add(h*60+m);
        }
        Collections.sort(minutes);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.size() - 1; i++) {
            int currentDiff = minutes.get(i + 1) - minutes.get(i);
            minDiff = Math.min(minDiff, currentDiff);
        }
        int firstTime = minutes.get(0);
        int lastTime = minutes.get(minutes.size() - 1);
        int wrapAroundDiff = (1440 - lastTime) + firstTime;
        minDiff = Math.min(minDiff, wrapAroundDiff);
        return minDiff;
    }
}