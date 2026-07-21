class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int x = 0;
        int y = 0;
        int count = 0;
        while(x<g.length&& y<s.length){
            if(s[y]>=g[x]){
                x++;
                count++;
            }
            y++;
        }
        return count++;
    }
}