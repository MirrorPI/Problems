class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb
            .append(a)
            .append(b);
        
        
        int num1 = Integer.parseInt(sb.toString());
        int num2 = a * b * 2;
        return num1 >= num2 ? num1 : num2;
    }
}