import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<num_list.length; i+=n) {
            nums.add(num_list[i]);
        }
        
        int numsLen = nums.size();
        int[] answer = new int[numsLen];
        for(int i=0; i<numsLen; i++) {
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}