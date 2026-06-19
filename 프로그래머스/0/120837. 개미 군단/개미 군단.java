class Solution {
    public int solution(int hp) {
        int answer = 0;
        return hp/5 + (hp%5)/3 + (hp%5)%3;
    }
}