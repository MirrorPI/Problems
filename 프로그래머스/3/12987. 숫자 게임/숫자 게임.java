import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); //1 3 5 7
        Arrays.sort(B); //2 2 6 8 
        int cnt = 0;
        int checkIdx = 0;
        for(int a : A) {
            boolean finish = false;
            for(int i=checkIdx; i<B.length; i++) {
                if(finish) break;
                
                if(a < B[i]) {
                    cnt++;
                    checkIdx = i+1;
                    finish = true;
                }
            }
        }
        
        return cnt;
    }
}