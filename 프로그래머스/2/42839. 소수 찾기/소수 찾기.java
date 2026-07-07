import java.util.*;

class Solution {

    int len;
    Set<Integer> set;
    boolean[] visited;
    String numbers;

    public int solution(String numbers) {
        this.len = numbers.length();
        set = new HashSet<>();
        this.visited = new boolean[len];
        this.numbers = numbers;
        
        dfs(new StringBuilder());


        int ans = 0;
        for(int n : set) {
            if(isPrime(n)) ans++;
        }

        return ans;
    }
    private void dfs(StringBuilder current) {
        if(current.length() > 0) {
            this.set.add(Integer.parseInt(current.toString()));
        }

        for(int i=0; i<len; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            current.append(numbers.charAt(i));

            dfs(current);
            
            current.deleteCharAt(current.length() - 1);
            visited[i] = false;
        }
    }
    private boolean isPrime(int n) {
        if(n < 2) return false;
        
        for(int i=2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}