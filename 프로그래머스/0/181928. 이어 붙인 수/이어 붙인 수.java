class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for(int n : num_list) {
            if(n%2 == 0) even.append(n);
            else odd.append(n);
        }
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}