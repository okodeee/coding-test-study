import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (s.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        
        System.out.println(sb);
    }
}