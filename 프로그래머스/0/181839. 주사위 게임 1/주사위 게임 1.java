class Solution {
    public int solution(int a, int b) {
        if(a%2==0 && b%2==0) {
            return Math.abs(a-b);
        }
        
        return (a+b)%2==0 ? a*a+b*b : 2*(a+b);
    }
}