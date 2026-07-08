class Solution {
    public String[] solution(String[] strArr) {
        int len = strArr.length;
        String[] answer = new String[len];
        
        
        for(int i=0; i<len; i++) {
            int l = strArr[i].length();
            StringBuilder sb = new StringBuilder();
            if(i%2!=0) {
                for(int j=0; j<l; j++) {
                    sb.append(Character.toUpperCase(strArr[i].charAt(j)));
                }
            } else {
                for(int j=0; j<l; j++) {
                    sb.append(Character.toLowerCase(strArr[i].charAt(j)));
                }
            }
            answer[i] = sb.toString();
            
        }
        return answer;
    }
}