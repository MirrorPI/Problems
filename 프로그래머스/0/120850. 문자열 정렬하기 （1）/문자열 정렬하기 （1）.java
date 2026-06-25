import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> nums = new ArrayList<>();
        int len = my_string.length();
        for(int i=0; i<len; i++) {
            int n = my_string.charAt(i) - '0';
            if(n >= 0 && n <= 9) {
                nums.add(n);
            }
        }
        int newLen = nums.size();
        int[] answer = new int[newLen];
        
        Collections.sort(nums);
        for(int i=0; i<newLen; i++) {
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}