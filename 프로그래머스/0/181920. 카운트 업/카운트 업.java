class Solution {
    public int[] solution(int start_num, int end_num) {
        int len = end_num - start_num + 1;
        int[] ans = new int[len];
        ans[0] = start_num;
        for(int i=1; i<len; i++) {
            ans[i] = ans[i-1] + 1;
        }
        return ans;
    }
}