class Solution {
    public int solution(String s) {
        char ops = s.charAt(0);
        String newS = s.substring(1, s.length());
        int answer = 0;
        if(ops == '+') {
            answer = Integer.parseInt(newS);
        } else if (ops == '-') {
            answer = Integer.parseInt(newS) * -1;
        } else {
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}