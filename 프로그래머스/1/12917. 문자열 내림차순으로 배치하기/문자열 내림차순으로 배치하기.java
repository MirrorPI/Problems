import java.util.*;

class Solution {
    public String solution(String s) {
        int len = s.length();
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        
        StringBuilder sb = new StringBuilder(new String(carr));
        return sb.reverse().toString();
    }
}