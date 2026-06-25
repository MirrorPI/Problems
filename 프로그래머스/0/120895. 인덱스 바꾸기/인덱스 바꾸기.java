class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        if(num1 > num2) {
            int t = num1;
            num1 = num2;
            num2 = t;
        }
        
        char c1 = my_string.charAt(num2);
        char c2 = my_string.charAt(num1);
        
        for(int i=0; i<my_string.length(); i++) {
            if(i==num1) {
                sb.append(c1);
            } else if(i==num2){
                sb.append(c2);
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}