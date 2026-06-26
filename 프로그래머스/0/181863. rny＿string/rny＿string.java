class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        int len = rny_string.length();
        for(int i=0; i<len ;i++) {
            char c = rny_string.charAt(i);
            
            if(c == 'm') {
                sb.append('r').append('n');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}