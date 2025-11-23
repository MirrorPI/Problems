import java.io.*;
import java.util.*;

public class Main {

    static int E, S, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int year = 1;
        while(true){
            if((year-1)%15 + 1 == E && (year-1)%28 + 1 == S && (year-1)%19 + 1 == M){
                break;
            }
            year++;
        }
        System.out.print(year);
    }
}