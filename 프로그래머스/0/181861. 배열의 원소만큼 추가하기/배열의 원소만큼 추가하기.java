import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        for(int n : arr) {
            for(int i=0; i<n; i++) {
                nums.add(n);
            }
        }
        int len = nums.size();
        int[] ans = new int[len];
        for(int i=0; i<len; i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }
}