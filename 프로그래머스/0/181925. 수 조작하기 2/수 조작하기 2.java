class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int ex = numLog[0];
        for(int i=1; i<numLog.length; i++) {
            int curr = numLog[i];
            if(ex + 1 == curr) {
                sb.append('w');
            } else if(ex - 1 == curr) {
                sb.append('s');
            } else if(ex + 10 == curr) {
                sb.append('d');
            } else {
                sb.append('a');
            }
            ex = curr;
        }
        
        return sb.toString();
    }
}