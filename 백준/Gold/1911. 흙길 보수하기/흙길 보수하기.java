import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //웅덩이 수(1~10,000)
    static int L; //웅덩이를 덮을 수 있는 길이(1~1,000,000)
    public static class Puddle {
        int start; //시작위치(0~1,000,000,000)
        int end; //끝 위치(start~1,000,000,000)
        Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static Puddle[] puddle;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        puddle = new Puddle[N];
        L = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            puddle[i] = new Puddle(s, e);
        }
        br.close();
    }
    public static void solve() {
        Arrays.sort(puddle, (p1, p2) -> {
            return Integer.compare(p1.start, p2.start);
        });
        int lastPuddleEnd = puddle[N-1].end;

        int plankEnd = 0;
        int cnt = 0;
        for(Puddle p : puddle) {
            //System.out.print(p.start + " " + p.end + "\n");
            int plankStart;
            int nowPuddleLength;
            if(plankEnd <= p.start) {
                plankStart = p.start;
            } else {
                plankStart = plankEnd;
            }
            nowPuddleLength = p.end - plankStart;
            if(nowPuddleLength <= 0) continue;

            int needPlank = nowPuddleLength % L == 0 ? nowPuddleLength / L : nowPuddleLength / L + 1;
            cnt += needPlank;
            plankEnd = plankStart + needPlank * L;
            if(lastPuddleEnd <= plankEnd) {
                System.out.print(cnt);
                return;
            }
        }
    }
}