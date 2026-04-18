import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        //dp의 i번째 집합은 N을 i개 사용해서 만들 수 있는 숫자들을 저장
        //0번째 인덱스는 사용하지 않음.
        dp.add(new HashSet<>());
        
        //N을 count만큼 사용해서 나올 수 있는 숫자들을 차례로 저장할거임
        for(int count = 1; count <= 8; count++){ 
            Set<Integer> current = new HashSet<>();
            
            //N, NN, NNN, ... 
            current.add(makeRepeatedNum(N, count));
            
            //i개 사용 집합과 (count - i) 사용 집합의 원소들을 연산 = count개 사용한 집합
            for(int i=1; i<count; i++) {
                Set<Integer> left = dp.get(i); //i번 사용해서 만든 숫자들
                Set<Integer> right = dp.get(count-i);//count-i 사용해서 만든 숫자들
                 
                for(int l : left) {
                    for(int r : right) {
                        current.add(l + r);
                        current.add(l - r);
                        current.add(l * r);
                        if(r != 0) {
                            current.add(l / r);
                        }
                    }
                }
            }
            if(current.contains(number)) return count;
            
            dp.add(current);
        }
        return -1;
    }
    public int makeRepeatedNum(int N, int count) {
        int num = 0;
        for(int i=0; i<count; i++) {
            num = num * 10 + N;
        }
        return num;
    }
}