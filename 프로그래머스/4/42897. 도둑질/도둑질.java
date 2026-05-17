class Solution {
    public int solution(int[] money) {
        int len = money.length;

        int notPick = 0;
        int pick = money[0];

        for(int i = 1; i < len - 1; i++) {
            int nextNotPick = Math.max(notPick, pick);
            int nextPick = notPick + money[i];

            notPick = nextNotPick;
            pick = nextPick;
        }

        int result1 = Math.max(notPick, pick);

        notPick = 0;
        pick = money[1];

        for(int i = 2; i < len; i++) {
            int nextNotPick = Math.max(notPick, pick);
            int nextPick = notPick + money[i];

            notPick = nextNotPick;
            pick = nextPick;
        }

        int result2 = Math.max(notPick, pick);

        return Math.max(result1, result2);
    }
}