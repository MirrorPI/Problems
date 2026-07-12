class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        int ans = 0;
        if(len >= 11) {
            for(int n : num_list) {
                ans += n;
            }
            
            return ans;
        }
        
        ans = 1;
        
        for(int n: num_list) {
            ans *= n;
        }
        
        return ans;
    }
}