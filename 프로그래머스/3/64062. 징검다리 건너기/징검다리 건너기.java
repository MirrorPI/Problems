class Solution {
    public int solution(int[] stones, int k) {
        int max = 0;
        for(int i=0; i<stones.length; i++) {
            max = Math.max(max, stones[i]);
        }
        
        int start = 0;
        int end = max;
        int answer = 0;
        while(start <= end) {
            int mid = (start + end)/2;
            
            if(check(stones, mid, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] stones, int people, int k) {
        int count = 0;
        for(int i=0; i<stones.length; i++) {
            if(stones[i] < people) {
                count += 1;
            } else {
                count = 0;
            }
            
            if(count == k) return false;
        }
        
        return true;
    }
}