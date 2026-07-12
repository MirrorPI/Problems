import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> finish = new ArrayList<>();
        for(int i=0; i<todo_list.length; i++) {
            if(finished[i]) continue;
            
            finish.add(todo_list[i]);
        }
        
        return finish.toArray(new String[0]);
     }
}