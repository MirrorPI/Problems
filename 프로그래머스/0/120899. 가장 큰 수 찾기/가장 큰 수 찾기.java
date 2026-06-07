import java.util.*;

class Solution {
    
    public int[] solution(int[] array) {
        int len = array.length;
        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<len ;i++) {
            if(array[i] > max) {
                max = array[i];
                maxIdx = i;
            }
        }

        int[] answer = {max, maxIdx};
        return answer;
    }
}