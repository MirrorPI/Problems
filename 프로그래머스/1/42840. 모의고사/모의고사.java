import java.util.*;

class Solution {
    //1 2 3 4 5 //len = 5
    //2 1 2 3 2 4 2 5 //len = 8
    //3 3 1 1 2 2 4 4 5 5 //len = 10
    public ArrayList<Integer> solution(int[] answers) {
        int[][] pick = new int[][] {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] len = new int[] {pick[0].length, pick[1].length, pick[2].length};

        int[] cnt = new int[3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == pick[i][j%len[i]]) {
                    cnt[i]++;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++) {
            max = Math.max(max, cnt[i]);
        }
        for(int i=0; i<3; i++) {
            if(cnt[i] == max) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}