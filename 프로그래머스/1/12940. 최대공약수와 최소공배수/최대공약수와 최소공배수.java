class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;
        
        return new int[] {gcd, lcm};
    }
    
    private int gcd(int n, int m) {
        while(m != 0) {
            int temp = n%m;
            n = m;
            m = temp;
        }
        
        return n;
    }
}