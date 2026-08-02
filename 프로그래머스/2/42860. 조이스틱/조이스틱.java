import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        for(int i=0; i<len; i++) {
            char c = name.charAt(i);
            int cnt = Math.min(c - 'A', 26 - (c - 'A'));
            answer += cnt;
        }
        
        //그냥 오른쪽으로만 가거나
        int min = len - 1;
        //하나의 A구간을 피해가거나 -> A구간이 2개 이상이라면 구간 사이 처리해야할 이름이 있기에 하나 이상은 지날 수 밖에 없음
        //그래서 하나의 구간만 피하고 나머지는 지나는 경우 -> 이 말은 돌아가야하는 경우 -> 오른쪽으로 갔다가 왼쪽으로 가는 경우 또는 왼쪽으로 갔다가 오른쪽으로 가는 경우
        //i 는 내가 멈출 곳, cursor 는 A구간의 끝이라 멈출 곳

        // -> i를 0에서 len-1까지 다 보는 이유? -> 사실 모든 A구간의 시작과 끝을 찾아서 그 값으로 비교하는 게 맞지만 
        //길이가 짧기 때문에 그냥 모든 인덱스에 대해서 멈출 A구간(cursor)만 찾아서 값 비교.
        for(int i=0; i<len; i++) {
            int cursor = i+1;
            
            //A 구간의 끝. 멈출 곳 찾기
            while(cursor < len && name.charAt(cursor) == 'A') {
                cursor += 1;
            }
            
            int rightFirst = i * 2 + len - cursor; 
            // 0----->i
            // 0<-----i
            //         AAAAAA cursor<----len
            int leftFirst = (len - cursor) * 2 + i;
            //         AAAAAAcursor<-----len
            //         AAAAAAcursor----->len
            // 0----->i
            
            min = Math.min(min, rightFirst);
            min = Math.min(min, leftFirst);
        } 
        answer += min;
        
        return answer;
    }
   
   
}
