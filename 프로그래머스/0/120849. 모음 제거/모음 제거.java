import java.util.*;

class Solution {
    
    public String solution(String my_string) {

        StringBuilder sb = new StringBuilder();

        Set<Character> vowels = new HashSet<>();
        char[] vowel = {'i', 'e', 'a', 'o', 'u'};
        for(char v : vowel) {
            vowels.add(v);
        }
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(vowels.contains(c)) continue;
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}