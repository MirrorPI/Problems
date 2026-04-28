import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numStr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStr, (n1, n2) -> (n2+n1).compareTo(n1+n2));
        
        if(numStr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String num : numStr) {
            sb.append(num);
        }
        
        
        return sb.toString();
    }
}