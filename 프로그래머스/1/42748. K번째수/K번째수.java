import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int m = commands.length;
        int[] answer = new int[m];
        for(int c=0; c<m; c++){
            ArrayList<Integer> newArr = new ArrayList<>();
            int i = commands[c][0]-1;
            int j = commands[c][1]-1;
            int k = commands[c][2]-1;
            for(int l=i; l<=j; l++){
                newArr.add(array[l]);
            }
            newArr.sort((n1, n2) -> {
                return Integer.compare(n1, n2);
            });
            answer[c] = newArr.get(k);
        }
        return answer;
    }
}