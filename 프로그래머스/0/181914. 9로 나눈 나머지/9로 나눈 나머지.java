class Solution {
    public int solution(String number) {
        int sum = 0;
        int numLen = number.length();
        for(int i=0; i<numLen; i++) {
            sum += number.charAt(i) - '0';
        }
        
        return sum % 9;
    }
}