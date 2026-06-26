class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len+1];
        for(int i=0; i<len; i++) {
            answer[i] = num_list[i];
        }
        int beforeLast = num_list[len-2];
        int last = num_list[len-1];
        answer[len] = beforeLast < last ? last - beforeLast : last * 2;
        return answer;
    }
}