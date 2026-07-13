class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        answer[0] = -1;
        
        for(int i=1; i<len; i++) {
            char c = s.charAt(i);
            boolean find = false;
            for(int j=i-1; j>=0; j--) {
                if(s.charAt(j) == c) {
                    answer[i] = i-j;
                    find = true;
                    break;
                }
            }
            if(!find) answer[i] = -1;
        }
        
        
        return answer;
    }
}