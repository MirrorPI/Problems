class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        for(int i=0; i<len; i++) {
            char c = my_string.charAt(i);
            
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}