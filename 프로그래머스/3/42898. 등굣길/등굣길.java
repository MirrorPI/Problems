class Solution {
    
    final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        long[][] numOfShortestPath = new long[m+1][n+1];
        boolean[][] blocked = new boolean[m+1][n+1];
        for(int[] p : puddles){
            blocked[p[0]][p[1]] = true;
        }
        numOfShortestPath[1][1] = 1;
        for(int x=1; x<=m; x++){
            for(int y=1; y<=n; y++){
                if(x==1 && y==1) continue;
                if(blocked[x][y]) continue;
                
                numOfShortestPath[x][y] = (numOfShortestPath[x-1][y] + numOfShortestPath[x][y-1])%MOD;
            }
        }
        return (int)numOfShortestPath[m][n];
    }
}