import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        int newN = my_string.length() * n;
        for(int i=0; i<newN; i++) {
            sb.append(my_string.charAt(i/n));
        }
        
        return sb.toString();
    }
}