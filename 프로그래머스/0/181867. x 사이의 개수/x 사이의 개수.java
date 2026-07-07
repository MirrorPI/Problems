import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x");
        List<Integer> lenList = new ArrayList<>();
        for(String s : strArr) {
            lenList.add(s.length());
        }
        if(myString.charAt(myString.length()-1) == 'x') lenList.add(0);
        
        int ansLen = lenList.size();
        int[] answer = new int[ansLen];
        int i = 0;
        for(int l : lenList) {
            answer[i++] = l;
        }
        
        return answer;
    }
}