class Solution {
    public int solution(int[] num_list) {
        int allMultiply = 1;
        int sum = 0;
        int sumSquare = 0;
        for(int n : num_list) {
            allMultiply *= n;
            sum += n;
        }
        sumSquare = sum * sum;
        
        return allMultiply < sumSquare ? 1 : 0;
        
    }
}