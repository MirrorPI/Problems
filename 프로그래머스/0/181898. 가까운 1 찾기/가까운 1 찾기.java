class Solution {
    public int solution(int[] arr, int idx) {
        int right = -1;
        
        for(int i=idx; i<arr.length; i++) {
            if(arr[i] == 1) {
                right = i;
                break;
            }
        }
        
        return right;
    }
}