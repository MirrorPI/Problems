class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        int length = my_string.length();
        boolean[] isDeleted = new boolean[length];
        for(int i=0; i<indices.length; i++) {
            isDeleted[indices[i]] = true;
        }
        
        for(int i=0; i<length; i++) {
            if(isDeleted[i]) continue;
            
            sb.append(my_string.charAt(i));
        }
        
        return sb.toString();
    }
}