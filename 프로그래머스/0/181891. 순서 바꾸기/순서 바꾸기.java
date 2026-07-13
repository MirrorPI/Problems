class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] newNumList = new int[len];
        for(int i=n; i<len+n; i++) {
            newNumList[i-n] = num_list[i%len];
        }
        
        return newNumList;
    }
}