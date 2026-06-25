class Solution {
    public int solution(int[] numbers) {
        int max = -100000000;
        int len = numbers.length;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i == j) continue;
                
                max = Math.max(max, numbers[i] * numbers[j]);
            }
        }
        
        return max;
    }
}