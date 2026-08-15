import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++) {
            int newIntStr = Integer.parseInt(intStrs[i].substring(s, s+l));
            
            if(k < newIntStr) ans.add(newIntStr);
        }
        
        int len = ans.size();
        int[] answer = new int[len];
        for(int i=0; i<len; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}