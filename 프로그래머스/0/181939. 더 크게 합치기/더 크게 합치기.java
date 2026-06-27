class Solution {
    public int solution(int a, int b) {
        StringBuilder sbAB = new StringBuilder();
        StringBuilder sbBA = new StringBuilder();
        int ab = Integer.parseInt(sbAB.append(a).append(b).toString());
        int ba = Integer.parseInt(sbBA.append(b).append(a).toString());
        
        return ab > ba ? ab : ba;
    }
}