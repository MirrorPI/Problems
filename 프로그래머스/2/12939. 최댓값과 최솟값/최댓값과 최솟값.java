import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int n = st.countTokens();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        String answer = arr[0] + " " + arr[n-1];
        return answer;
    }
}