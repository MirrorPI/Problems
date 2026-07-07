import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        
        int ansLen = st.countTokens();
        String[] ans = new String[ansLen];
        for(int i=0; i<ansLen; i++) {
            ans[i] = st.nextToken();
        }
        
        return ans;
    }
}