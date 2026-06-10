import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for(int i=2; i<=n/2; i++) {
            if(n % i == 0) divisors.add(i);
        }
        if(n!= 1) divisors.add(n);
        int size = divisors.size();
        int[] answers = new int[size];
        for(int i=0; i<size; i++) {
            answers[i] = divisors.get(i);
        }
        
        return answers;
    }
}