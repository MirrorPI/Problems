class Solution {
    public int solution(String my_string, String is_prefix) {
        int strLen = my_string.length();
        for(int i=0; i<strLen; i++) {
            String prefix = my_string.substring(0, i);
            if(prefix.equals(is_prefix)) return 1;
        }
        
        return 0;
    }
}