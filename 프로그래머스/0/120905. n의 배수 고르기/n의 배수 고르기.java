import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int m : numlist) {
            if(m % n == 0) {
                list.add(m);
            }
        }
        
        int len = list.size();
        int[] answer = new int[len];
        for(int i=0; i<len; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}