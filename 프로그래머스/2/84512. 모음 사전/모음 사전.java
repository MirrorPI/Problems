class Solution {
    
    char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    boolean found = false;
    
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        
        return cnt;
    }
    public void dfs(StringBuilder sb, String target) {
        if(found) return;
        if(sb.length() == 5) return;
        
        for(int i=0; i<alphabets.length; i++) {
            sb.append(alphabets[i]);
            cnt++;
            if(target.equals(sb.toString())) {
                found = true;
                return;
            }
            dfs(sb, target);
            if(target.equals(sb.toString())) {
                found = true;
                return;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}