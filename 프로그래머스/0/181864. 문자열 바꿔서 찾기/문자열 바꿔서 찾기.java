class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        int len = myString.length();
        for(int i=0; i<len; i++) {
            char c = myString.charAt(i);
            
            if(c == 'A') sb.append('B');
            else sb.append('A');
        }
        
        return sb.toString().contains(pat) ? 1 : 0;
    }
}