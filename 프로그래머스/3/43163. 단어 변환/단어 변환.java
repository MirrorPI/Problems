import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        if(!containsTarget(target, words)) {
            return 0;
        }
        
        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<String> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(begin);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                String curr = q.poll();
                
                if(curr.equals(target)) {
                    return count;
                }
                
                for(int j=0; j<words.length; j++) {
                    if(visited[j]) continue;
                    
                    if(canTransform(curr, words[j])) {
                        q.add(words[j]);
                        visited[j] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }
    
    public boolean containsTarget(String target, String[] words) {
        for(String word : words) {
            if(word.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public boolean canTransform (String u, String v) {
        int diffCount = 0;
        
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) != v.charAt(i)) {
                diffCount++;
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}