class Solution {
    final int lamb = 12_000;
    final int drink = 2_000;
    public int solution(int n, int k) {
        int d = k - n / 10;
        d = d < 0 ? 0 : d;
        
        return n * lamb + d * drink;
    }
}