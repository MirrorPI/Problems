class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String ageStr = Integer.toString(age);
        for(int i=0; i<ageStr.length(); i++) {
            sb.append((char)(ageStr.charAt(i) - '0' + 'a'));
        }
        return sb.toString();
    }
}