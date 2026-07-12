import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> leader = new ArrayList<>();
        int len = names.length;
        for(int i=0; i<len; i++) {
            if(i%5==0) leader.add(names[i]);
        }
        
        
        return leader.toArray(new String[0]);
    }
}