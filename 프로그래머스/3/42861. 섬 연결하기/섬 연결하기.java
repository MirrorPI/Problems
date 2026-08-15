import java.util.*;

class Solution {
    
    int N; //섬의 개수
    int[] p;
    ArrayList<Bridge> bridges;
    class Bridge {
        int u;
        int v;
        int c;
        Bridge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }
    }
    
    public int solution(int n, int[][] costs) {
        N = n;
        p = new int[N+1];
        Arrays.fill(p, -1);
        bridges = new ArrayList<>();
        
        for(int i=0; i<costs.length; i++) {
            int u = costs[i][0];
            int v = costs[i][1];
            int c = costs[i][2];
            
            bridges.add(new Bridge(u, v, c));
        }
        
        bridges.sort((b1, b2) -> {
            return Integer.compare(b1.c, b2.c);
        });
        
        int minCost = 0;
        for(Bridge bridge: bridges) {
            int u = bridge.u;
            int v = bridge.v;
            int c = bridge.c;
            
            if(find(u) != find(v)) {
                minCost += c;
                union(u, v);
            }
        }
        
        return minCost;
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