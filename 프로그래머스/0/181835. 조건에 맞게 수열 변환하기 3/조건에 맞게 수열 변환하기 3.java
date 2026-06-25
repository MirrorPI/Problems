class Solution {
    public int[] solution(int[] arr, int k) {
        int len = arr.length;
        int[] ans = new int[len];
        
        if(k%2==0) {
            for(int i=0; i<len; i++) {
            int n = arr[i];
            ans[i] = n + k;
            }
        } else {
            for(int i=0; i<len; i++) {
            int n = arr[i];
            ans[i] = n * k;
            }
        }

        return ans;
    }
}