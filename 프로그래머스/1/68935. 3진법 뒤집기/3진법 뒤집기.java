class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;
        while(num > 0) {
            sb.append(num%3);
            
            num /= 3;
        }
        String reverse = sb.toString();
        return Integer.parseInt(reverse, 3);
    }
}