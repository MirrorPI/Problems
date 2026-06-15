class Solution {
    boolean solution(String s) {
        int pcnt = 0;
        int ycnt = 0;
        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            
            if(a == 'p' || a == 'P') {
                pcnt++;
                continue;
            }
            if(a == 'y' || a == 'Y') {
                ycnt++;
                continue;
            }
        }

        return pcnt == ycnt;
    }
}