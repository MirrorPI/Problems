import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int tlen = t.length();
        int plen = p.length();
        int ans = 0;
        
        long pnum = Long.parseLong(p);
        for(int i=0; i<=tlen - plen; i++) {
            long tnum = Long.parseLong(t.substring(i, i+plen));
            if(tnum <= pnum) ans++;
        }
        return ans;
    }
}