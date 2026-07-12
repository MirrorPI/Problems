class Solution {
    public int solution(String myString, String pat) {
        int lenM = myString.length();
        int lenP = pat.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lenM; i++) {
            sb.append(Character.toLowerCase(myString.charAt(i)));
        }
        String newMyString = sb.toString();
        
        sb.delete(0, lenM);
        
        for(int i=0; i<lenP; i++) {
            sb.append(Character.toLowerCase(pat.charAt(i)));
        }
        String newPat = sb.toString();
        
        return newMyString.contains(newPat) ? 1 : 0;
    }
}