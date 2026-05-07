class Solution {
    public int solution(String arr[]) {
        int len = arr.length;

        char[] ops = new char[len];

        for (int i = 1; i < len; i += 2) {
            ops[i] = arr[i].charAt(0);
        }

        int[][] max = new int[len][len];
        int[][] min = new int[len][len];

        for(int i=0; i<len; i+=2) {
            max[i][i] = Integer.parseInt(arr[i]);
            min[i][i] = Integer.parseInt(arr[i]);
        } 

        for(int gap=2; gap<len; gap+=2) {
            for(int start=0; start+gap<len; start+=2) {
                int end = start + gap;
                
                max[start][end] = Integer.MIN_VALUE;
                min[start][end] = Integer.MAX_VALUE;
                
                for(int signIdx=start+1; signIdx<end; signIdx+=2) {
                    int leftMax = max[start][signIdx-1];
                    int leftMin = min[start][signIdx-1];
                    int rightMax = max[signIdx+1][end];
                    int rightMin = min[signIdx+1][end];
                    
                    int candidateMax;
                    int candidateMin;
                    
                    if(ops[signIdx] == '+') {
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
        
        return max[0][len-1];
    }
}