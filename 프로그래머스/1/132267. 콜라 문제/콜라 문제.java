class Solution {
    public int solution(int a, int b, int n) {
        int empties = 0;
        int answer = 0;
        while(n + empties >= a) {
            empties += n;
            n = (empties/a) * b;
            answer += n;
            empties = empties%a;
        }
        
        return answer;
    }
}