import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.addLast(0);
        for(int i=1; i<prices.length; i++) {
            while(!st.isEmpty() && prices[i] < prices[st.peekLast()]) {
                int lastIdx = st.pollLast();
                answer[lastIdx] = i - lastIdx;
            }
            
            st.addLast(i);
        }
        while(!st.isEmpty()) {
            int idx = st.pollLast();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}
