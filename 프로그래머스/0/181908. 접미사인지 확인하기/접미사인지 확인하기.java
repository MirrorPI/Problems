class Solution {
    public int solution(String my_string, String is_suffix) {
        int len = my_string.length();
        for(int i=0; i<len; i++) {
            if(my_string.substring(i).equals(is_suffix)) return 1;
        }
        
        return 0;
    }
}