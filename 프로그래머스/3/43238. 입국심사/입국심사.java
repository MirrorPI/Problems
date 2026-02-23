class Solution {
    //심사 받을 사람 n명 (1~1,000,000,000)
    //심사관 m명 (1~100,000)
    //times[i] i번째 심사관의 심사시간 (1~1,000,000,000)
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1_000_000_000L * 1_000_000_000L;
        long ans = 0L;
        while(start <= end) {
            long mid = (start + end)/2;
            if(available(times, mid, n)) {
                end = mid-1;
                ans = mid;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean available(int[] times, long time, int n){
        long availablePeople = 0;
        for(int i=0; i<times.length; i++){
            availablePeople += time/times[i];
            if(availablePeople >= n) return true;
        }
        return false;
    }
}