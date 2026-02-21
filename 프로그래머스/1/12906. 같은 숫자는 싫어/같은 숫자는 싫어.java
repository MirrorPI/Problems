import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            int cur = list.get(list.size()-1);
            if(cur == arr[i]) continue;
            
            list.add(arr[i]);
        }

        return list;
    }
}