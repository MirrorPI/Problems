import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int strLen = my_string.length();
        String[] answer = new String[strLen];
        for(int i=0; i<strLen; i++) {
            answer[i] = my_string.substring(i, strLen);
        }
        Arrays.sort(answer);
        return answer;
    }
}