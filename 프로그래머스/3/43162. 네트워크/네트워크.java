import java.util.*;

class Solution {
    
    int[] p;
    
    public int solution(int n, int[][] computers) {
        p = new int[n]; Arrays.fill(p, -1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(p[i] < 0) {
                ans++;
            }
        }
        return ans;
    }
    public int find(int x) {
        if(p[x] < 0) return x;
        
        return p[x] = find(p[x]);
    }
    public void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(u == v) return;
        
        if(p[u] > p[v]) {
            int t = u;
            u = v;
            v = t;
        }
        
        if(p[u] == p[v]) p[u]--;
        
        p[v] = u;
    }
}