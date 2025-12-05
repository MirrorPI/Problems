import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static class Student {
        String name;
        int k;
        int e;
        int m;
        Student(String name, int k, int e, int m){
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, k, e, m);
        }
        Arrays.sort(students, (s1, s2) -> {
            if(s1.k == s2.k) {
                if(s1.e == s2.e) {
                    if(s1.m == s2.m) {
                        return s1.name.compareTo(s2.name);
                    }
                    return Integer.compare(s2.m, s1.m);
                }
                return Integer.compare(s1.e, s2.e);
            }
            return Integer.compare(s2.k, s1.k);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(students[i].name).append("\n");
        }
        System.out.print(sb);
    }
}