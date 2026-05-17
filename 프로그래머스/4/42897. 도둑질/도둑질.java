class Solution {
    public int solution(int[] money) {
        int len = money.length;

        int pick = money[0]; //첫번째 집 선택 -> 마지막 집 선택 못함
        int notPick = 0; 
        for(int i=1; i<len-1; i++) { //len-2까지 마지막 집 선택 못함
            int nextNotPick = Math.max(notPick, pick); //다음 집을 선택안한다. -> 지금 집을 선택 안했을 때, 지금 집을 선택했을 때 값 중 큰 걸 기억함
            int nextPick = notPick + money[i]; //다음 집을 선택한다. -> 지금 집 선택 안했을 때 값 + 다음 집 선택

            notPick = nextNotPick;
            pick = nextPick;
        }

        int resultFirstPick = Math.max(notPick, pick);

        pick = money[1]; //두번째 집 선택 -> 마지막 집 선택 가능
        notPick = 0;
        
        for(int i=2; i<len; i++) { //len-1 까지 마지막 집 선택 가능
            int nextNotPick = Math.max(notPick, pick); //다음 집을 선택안한다. -> 지금 집을 선택 안했을 때, 지금 집을 선택했을 때 값 중 큰 걸 기억함
            int nextPick = notPick + money[i]; //다음 집을 선택한다. -> 지금 집 선택 안했을 때 값 + 다음 집 선택

            notPick = nextNotPick;
            pick = nextPick;
        }

        int resultFirstNotPick = Math.max(notPick, pick);
        
        return Math.max(resultFirstPick, resultFirstNotPick);
    }
}