import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            if (s.ceiling(x) == null) {
                sb.append(-1).append('\n');
            } else {
                sb.append(s.ceiling(x)).append('\n');
            }
        }

        System.out.println(sb);
    }
}