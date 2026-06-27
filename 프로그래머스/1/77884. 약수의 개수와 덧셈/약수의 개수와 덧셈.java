class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int n=left; n<=right; n++) {
            int count = 0;
            for(int i=1; i*i<=n; i++) {
                if(i*i == n) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
            if(count%2 == 0) {
                answer += n;
            } else {
                answer -= n;
            }
        }
        
        return answer;
    }
}