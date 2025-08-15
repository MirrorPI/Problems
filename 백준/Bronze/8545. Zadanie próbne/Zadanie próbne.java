import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            sb.append(input.charAt(input.length()-1-i));
        }
        System.out.print(sb);
    }
}