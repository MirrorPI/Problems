import java.util.*;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        int a = Integer.parseInt(st.nextToken());
        char op = st.nextToken().charAt(0);
        int b = Integer.parseInt(st.nextToken());
        
        if(op == '+') return a + b;
        
        if(op == '-') return a - b;
        
        return a * b;
    }
    
    
}