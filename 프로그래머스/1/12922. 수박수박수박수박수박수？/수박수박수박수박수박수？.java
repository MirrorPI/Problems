class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String subak = "수박";
        String su = "수";
        for(int i=0; i<n/2; i++) {
                sb.append(subak);
            }
        if(n%2 != 0) {
            sb.append(su);
        }
        
        return sb.toString();
    }
}