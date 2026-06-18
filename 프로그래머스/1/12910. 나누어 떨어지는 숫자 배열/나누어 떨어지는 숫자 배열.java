import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> l = new ArrayList<>();
        for(int n : arr) {
            if(n%divisor == 0) l.add(n);
        }
        Collections.sort(l);
    
        int len = l.size();
        if(len == 0) return new int[] {-1};
        
        int[] answer = new int[len];
        for(int i=0; i<len; i++) {
            answer[i] = l.get(i);
        }
        return answer;
    }
}