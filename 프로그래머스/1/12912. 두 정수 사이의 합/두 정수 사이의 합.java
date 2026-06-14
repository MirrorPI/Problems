class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        
        if(a > b) {
            int t = a;
            a = b;
            b = t;
        }
        
        if(a < 0 && b < 0) {
            return -1 * cal(-1 * b, -1 * a);
        } 
        
        if(a < 0) {
            return -1 * cal(1, -1 * a) + cal(1, b);
        }
        
        if(a == 0) {
            return cal(1, b);
        }
        
        if(b == 0) {
            return -1 * cal(1, -1 * a);
        }
        
        return cal(a, b);
    }
    
    public long cal(long a, long b) {
        return b*(b+1)/2 - a*(a-1)/2;
    }
}