class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int c = len/2;
        if(len%2 == 0) {
            sb.append(s.charAt(c-1)).append(s.charAt(c));
        } else {
            sb.append(s.charAt(c));
        }
        
        return sb.toString();
    }
}