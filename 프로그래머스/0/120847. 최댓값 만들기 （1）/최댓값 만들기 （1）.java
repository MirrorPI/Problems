import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 1;
        Arrays.sort(numbers);
        for(int i = numbers.length-1; i>numbers.length-3; i--) {
            answer *= numbers[i];
        }
        return answer;
    }
}