import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> m = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int e = Integer.parseInt(st.nextToken());
            m.put(e, m.getOrDefault(e, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int e = Integer.parseInt(st.nextToken());

            sb.append(m.getOrDefault(e, 0)).append(' ');
        }

        System.out.println(sb);
    }
}