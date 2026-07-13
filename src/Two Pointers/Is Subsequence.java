class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointers = 0;
        int pointerr = 0;
        while(pointers<s.length()&&pointerr<t.length()){
            if(s.charAt(pointers)==t.charAt(pointerr)){
                pointers++;
            }
            pointerr++;
        }
        return pointers==s.length();
    }
}