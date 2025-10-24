import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> ioLog = new HashMap<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("enter")){
                ioLog.put(name, true);
            } else {
                ioLog.put(name, false);
            }
        }
        ArrayList<String> in = new ArrayList<>();
        for(String name : ioLog.keySet()){
            if(ioLog.get(name)){
                in.add(name);
            }
        }
        in.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String name : in){
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}