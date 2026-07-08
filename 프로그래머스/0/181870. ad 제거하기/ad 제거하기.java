import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> sarr = new ArrayList<>();
        for(String s : strArr) {
            if(s.contains("ad")) continue;
            
            sarr.add(s);
        }
        
        return sarr.toArray(new String[0]);
    }
}