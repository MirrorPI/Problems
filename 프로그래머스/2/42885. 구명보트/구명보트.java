import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int peopleCnt = people.length;
        int aloneIdx = peopleCnt - 1;
        
        Arrays.sort(people);
        
        int rescuedCnt = 0;
        int moveCnt = 0;
        int i = 0;
        while(rescuedCnt < peopleCnt) {
            int sum = people[i] + people[aloneIdx];
            if(sum > limit) {
                aloneIdx -= 1;
                moveCnt += 1;
                rescuedCnt += 1;
            } else {
                i += 1;
                moveCnt += 1;
                aloneIdx -= 1;
                rescuedCnt += 2;
            }
        }
        
        return moveCnt;
    }
}