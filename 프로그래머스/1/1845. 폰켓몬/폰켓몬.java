import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int len = nums.length;
        HashSet<Integer> poketmon = new HashSet<>();
        for(int p : nums) {
            poketmon.add(p);
        }
        int cnt = poketmon.size();


        return cnt > len/2 ? len/2 : cnt;
    }
}