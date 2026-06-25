import java.util.*;

class Solution {
    public String solution(String my_string) {
        int len = my_string.length();
        char[] chars = new char[len];
        for(int i=0; i<len; i++) {
            chars[i] = Character.toLowerCase(my_string.charAt(i));
        }
        
        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            sb.append(chars[i]);
        }
        
        return sb.toString();
    }
}