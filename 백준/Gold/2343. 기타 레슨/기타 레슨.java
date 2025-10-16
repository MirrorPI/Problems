import java.io.*;
import java.util.*;

public class Main {

    static int N; //강의의 개수(1~100,000)
    static int M; //블루레이 개수(1~100,000)
    static int[] lecture; //강의 시간(1~10,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecture = new int[N];
        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int t = Integer.parseInt(st.nextToken());
            lecture[i] = t;
            sum += t;
            max = Math.max(max, t);
        }
        int capacityLow = max;
        int capacityHigh = sum;
        int ans = sum;
        while(capacityLow<=capacityHigh){
            int mid = (capacityLow+capacityHigh)/2;
            if(canSave(mid)) {
                ans = mid;
                capacityHigh = mid-1; //저장할 수 있다면 용량을 줄여서 체크
            } else {
                capacityLow = mid+1; //저장할 수 없다면 용량을 늘려서 체크
            }
        }
        System.out.print(ans);
    }
    static boolean canSave(int capacity){
        int idx = 0;
        int curTotalT = 0;
        for(int t : lecture){
            if(t > capacity) return false;

            if(curTotalT + t > capacity) { //현재까지 저장한 강의 시간 + 이제 저장할 강의가 블루레이 용량을 넘어서면 다음 블루레이로 넘어감
                idx++;
                curTotalT = 0;
            }
            curTotalT += t;
            if(idx == M) return false; //모든 강의를 저장하기 전에 제공된 블루레이를 넘겨버리는 상황
        }
        return true;
    }
}