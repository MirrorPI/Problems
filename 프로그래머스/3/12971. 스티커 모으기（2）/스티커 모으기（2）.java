class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if (n == 1) {
            return sticker[0];
        }

        int firstChoice = getMax(sticker, 0, n - 2); 
        int firstNotChoice = getMax(sticker, 1, n - 1);

        return Math.max(firstChoice, firstNotChoice);
    }

    private int getMax(int[] sticker, int start, int end) {
        int len = end - start + 1;

        if (len == 1) {
            return sticker[start];
        }

        int[] dp = new int[sticker.length];

        dp[start] = sticker[start];
        dp[start + 1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        return dp[end];
    }
}