import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        solve();
    }

    static int K;
    static class Num {
        int value;
        boolean isActive;
        Num(int value) {
            this.value = value;
            this.isActive = true;
        }
        void disable() {
            this.isActive = false;
        }
    }
    static PriorityQueue<Num> minHeap;
    static PriorityQueue<Num> maxHeap;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int k = Integer.parseInt(br.readLine());
            minHeap = new PriorityQueue<>((n1, n2) -> {
                return Integer.compare(n1.value, n2.value);
            });
            maxHeap = new PriorityQueue<>((n1, n2) -> {
                return Integer.compare(n2.value, n1.value);
            });
            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                Num num = new Num(n);
                if(cmd.equals("I")) {
                    minHeap.add(num);
                    maxHeap.add(num);
                } else {
                    if(n == 1) {
                        while(true) {
                            if(maxHeap.isEmpty()) {
                                break;
                            } else {
                                Num max = maxHeap.poll();
                                if(max.isActive) {
                                    max.disable();
                                    break;
                                }
                            }
                        }
                    } else {
                        while(true) {
                            if(minHeap.isEmpty()) {
                                break;
                            } else {
                                Num min = minHeap.poll();
                                if(min.isActive) {
                                    min.disable();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            boolean minExist = false;
            boolean maxExist = false;
            int min = 0;
            int max = 0;
            while(true) {
                if(minHeap.isEmpty()) break;

                Num minNum = minHeap.poll();
                if(minNum.isActive) {
                    min = minNum.value;
                    max = minNum.value;
                    minExist = true;
                    break;
                }
            }
            while(true) {
                if(maxHeap.isEmpty()) break;

                Num maxNum = maxHeap.poll();
                if(maxNum.isActive) {
                    max = maxNum.value;
                    maxExist = true;
                    break;
                }
            }
            if(!minExist && !maxExist) {
                sb.append("EMPTY\n");
            } else if(minExist && maxExist) {
                sb.append(max).append(' ').append(min).append('\n');
            } else if (minExist) {
                sb.append(min).append(' ').append(min).append('\n');
            }else sb.append(max).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }
}