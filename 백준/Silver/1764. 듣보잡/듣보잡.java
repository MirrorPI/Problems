import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //듣도 못한 사람, 보도 못한 사람(1~500,000)
    static HashSet<String> names;
    static List<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        names = new HashSet<>();
        ans = new ArrayList<>();
        String name = "";
        for(int i=0; i<N; i++){
            name = br.readLine();
            names.add(name);
        }
        for(int i=0; i<M; i++){
            name = br.readLine();
            if(names.contains(name)){
                ans.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        Collections.sort(ans);
        for(String n : ans){
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}