import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static String my;
    static String doc;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        my = br.readLine();
        doc = br.readLine();
    }

    public static void solve() {
        int a = my.length();
        int b = doc.length();

        System.out.print(a >= b ? "go" : "no");
    }

}