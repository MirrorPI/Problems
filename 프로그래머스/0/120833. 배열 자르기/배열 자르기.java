class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int newSize = num2 - num1 + 1;
        int[] answer = new int[newSize];
        for(int i=0; i<newSize; i++){
            answer[i] = numbers[num1+i];
        }
        return answer;
    }
}