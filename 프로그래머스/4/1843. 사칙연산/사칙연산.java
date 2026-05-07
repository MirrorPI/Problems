class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;

        int[] nums = new int[n];
        char[] ops = new char[n - 1];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i * 2]);
        }

        for (int i = 0; i < n - 1; i++) {
            ops[i] = arr[i * 2 + 1].charAt(0);
        }

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            max[i][i] = nums[i];
            min[i][i] = nums[i];
        }

        for (int gap = 1; gap < n; gap++) {
            for (int start = 0; start + gap < n; start++) {
                int end = start + gap;

                max[start][end] = Integer.MIN_VALUE;
                min[start][end] = Integer.MAX_VALUE;

                for (int opIdx = start; opIdx < end; opIdx++) {
                    int leftMax = max[start][opIdx];
                    int leftMin = min[start][opIdx];
                    int rightMax = max[opIdx + 1][end];
                    int rightMin = min[opIdx + 1][end];

                    int candidateMax;
                    int candidateMin;

                    if (ops[opIdx] == '+') {
                        candidateMax = leftMax + rightMax;
                        candidateMin = leftMin + rightMin;
                    } else {
                        candidateMax = leftMax - rightMin;
                        candidateMin = leftMin - rightMax;
                    }

                    max[start][end] = Math.max(max[start][end], candidateMax);
                    min[start][end] = Math.min(min[start][end], candidateMin);
                }
            }
        }

        return max[0][n - 1];
    }
}