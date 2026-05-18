import java.util.*;

class Solution {
    boolean solution(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1; i<len; i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && c == ')') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        return st.size() == 0;
    }
}