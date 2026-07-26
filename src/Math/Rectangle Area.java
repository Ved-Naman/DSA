class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        int overlapLeft = Math.max(ax1, bx1);
        int overlapRight = Math.min(ax2, bx2);
        int overlapBottom = Math.max(ay1, by1);
        int overlapTop = Math.min(ay2, by2);

        int overlapWidth = Math.max(0, overlapRight - overlapLeft);
        int overlapHeight = Math.max(0, overlapTop - overlapBottom);

        int overlapArea = overlapWidth * overlapHeight;

        int totalArea = areaA + areaB - overlapArea;
        return totalArea;
    }
}