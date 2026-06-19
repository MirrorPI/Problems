class Solution {
    public int solution(int n) {
        int s = 1;
        int e = 1;
        int sum = 1;
        int count = 0;
        
        while(s <= e) {
            if(sum == n) {
                count++;
                if(e == n) return count;
            }
            
            if(sum < n) {
                e += 1;
                sum += e;
            } else {
                sum -= s;
                s += 1;
            }
        }
        
        return count;
    }
}