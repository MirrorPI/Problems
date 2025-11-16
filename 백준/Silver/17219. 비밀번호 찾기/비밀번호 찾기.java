import java.io.*;
import java.util.*;

public class Main {

    static int N; //저장된 사이트 수(1~100,000)
    static int M; //찾으려는 비밀번호의 수(1~100,000)
    static Map<String, String> password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        password = new HashMap<>();
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            String email = st.nextToken();
            String pass = st.nextToken();
            password.put(email, pass);
        }
        for(int i=0; i<M; i++){
            String email = br.readLine();
            sb.append(password.get(email)).append("\n");
        }
        System.out.print(sb);
    }
}