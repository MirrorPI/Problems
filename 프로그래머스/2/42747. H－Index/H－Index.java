import java.util.*;

class Solution {
    //6 5 3 1 0
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        
        int h = 0;
        for(int i=len-1; i>=0; i--) {
            int citationCnt = citations[i]; //논문의 인용된 수
            int paperCnt = len - i; //현재까지 카운트하고 있는 논문의 수

            if(citationCnt >= paperCnt) { //citationCnt 만큼 인용된 논문 수가 현재까지 카운트하고 있는 논문 수보다 큰가?
                h = paperCnt;
            }
        }
        
        return h;
    }
}