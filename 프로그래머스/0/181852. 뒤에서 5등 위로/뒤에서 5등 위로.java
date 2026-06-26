import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        Arrays.sort(num_list);
        int[] ans = new int[len-5];
        for(int i=5; i<len; i++) {
            ans[i-5] = num_list[i];
        }
        
        return ans;
    }
}