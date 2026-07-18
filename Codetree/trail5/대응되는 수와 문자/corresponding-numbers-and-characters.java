import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            m.put(str, String.valueOf(i+1));
            m.put(String.valueOf(i+1), str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(m.get(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }
}