class Solution {
    public boolean solution(String s) {
        return isValidLength(s.length()) && isDisitsOnly(s);
    }
    
    public boolean isValidLength(int len) {
        return len == 4 || len == 6;
    }
    public boolean isDisitsOnly(String s) {
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            
            if(c < '0' || c > '9') return false;
        }
        
        return true;
    }
}