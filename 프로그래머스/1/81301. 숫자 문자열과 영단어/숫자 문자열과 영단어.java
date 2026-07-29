class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int i =0;
        while(i < s.length()) {
            char c = s.charAt(i);
            int jump = 1;
            if(c == 'z') {
                c = '0';
                jump = 4;
            } else if(c == 'o') {
                c = '1';
                jump = 3;
            } else if(c == 't') {
                char nextC = s.charAt(i+1);
                if(nextC == 'w') {
                    c = '2';
                    jump = 3;
                } else {
                    c= '3';
                    jump = 5;
                }
            } else if(c == 'f') {
                char nextC = s.charAt(i+1);
                if(nextC == 'o') {
                    c = '4';
                    jump = 4;
                } else {
                    c= '5';
                    jump = 4;
                }
            } else if(c == 's') {
                char nextC = s.charAt(i+1);
                if(nextC == 'i') {
                    c = '6';
                    jump = 3;
                } else {
                    c= '7';
                    jump = 5;
                }
            } else if(c == 'e') {
                c = '8';
                jump = 5;
            } else if(c == 'n') {
                c = '9';
                jump = 4;
            }
            
            sb.append(c);
            i += jump;
        }
        
        return Integer.parseInt(sb.toString());
    }
}