import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int len = arr.length;
        
        
        Set<Integer> delNum = new HashSet<>();
        for(int n : delete_list) {
            delNum.add(n);
        }
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<len; i++) {
            int n = arr[i];
            if(delNum.contains(n)) continue;
            
            nums.add(n);
        }
        int newLen = nums.size();
        int[] ans = new int[newLen];
        
        for(int i=0; i<newLen; i++) {
            ans[i] = nums.get(i);
        }
         
        return ans;
    }
}