import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> nums = new ArrayList<>();
        for(int[] interval : intervals) {
            for(int i=interval[0]; i<=interval[1]; i++) {
                nums.add(arr[i]);
            }
        }
        int newLen = nums.size();
        int[] newArr = new int[newLen];
        for(int i=0; i<newLen; i++) {
            newArr[i] = nums.get(i);
        }
        
        return newArr;
    }
}