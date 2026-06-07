import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String s = Long.toString(n);
        int len = s.length();
        char[] c = new char[len];
        for(int i=0; i<len; i++) {
            c[i] = s.charAt(i);
        }
        Arrays.sort(c);
        for(int i=len-1; i>=0; i--) {
            sb.append(c[i]);
        }
        s = sb.toString();
        
        return Long.parseLong(s);
    }
}