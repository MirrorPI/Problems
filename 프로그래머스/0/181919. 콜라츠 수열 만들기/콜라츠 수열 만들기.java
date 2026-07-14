import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> nums = new ArrayList<>();
        int num = n;
        nums.add(num);
        while(num != 1) {
            if(num % 2 == 0) num /= 2;
            else num = num * 3 + 1;
            nums.add(num);
        }
        int size = nums.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}