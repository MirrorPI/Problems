class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if(len == 1) return new int[] {-1};
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<len; i++) {
            if(min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        int[] answer = new int[len-1];
        int cnt = 0;
        for(int i=0; i<len; i++) {
            if(i == idx) continue;
            answer[cnt++] = arr[i];
        }
        
        return answer;
    }
}