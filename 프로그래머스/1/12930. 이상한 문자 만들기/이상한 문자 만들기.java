import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cnt = 0;
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(c == ' ') cnt = -1;
            
            if(cnt%2==0) {
                c = Character.toUpperCase(c);   
            } else {
                c = Character.toLowerCase(c);
            } 
            
            sb.append(c);
            cnt++;
        }
        
        return sb.toString();
    }
}