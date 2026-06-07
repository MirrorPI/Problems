import java.util.*;

class Solution {
    
    class Num {
        int idx;
        int num;
        Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    
    public int[] solution(int[] array) {
        int len = array.length;
        Num[] nums = new Num[len];
        for(int i=0; i<len; i++) {
            nums[i] = new Num(i, array[i]);
        }
        Arrays.sort(nums, (n1, n2) -> {
            return Integer.compare(n2.num, n1.num);
        });

        int[] answer = {nums[0].num, nums[0].idx};
        return answer;
    }
}