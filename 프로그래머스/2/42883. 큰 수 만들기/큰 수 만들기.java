class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int curr = number.charAt(0) - '0';
        sb.append(curr);
        int count = 0;
        for(int i=1; i<number.length(); i++) {
            int next = number.charAt(i) - '0';
            while(count < k && sb.length() > 0 && sb.charAt(sb.length() - 1) - '0' < next) {
                sb.deleteCharAt(sb.length() - 1);
                count++;
            }
            
            curr = next;
            sb.append(next);
        }
        
        for(int i = count; i<k; i++) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}