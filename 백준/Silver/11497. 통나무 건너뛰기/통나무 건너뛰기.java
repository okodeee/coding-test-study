import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] logs;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            logs = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                logs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(logs);
            result = Integer.MAX_VALUE;

            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            s1.push(logs[0]);
            s2.push(logs[1]);
            result = Math.abs(logs[0] - logs[1]);
            for (int i = 2; i < N; i++) {
                if (i % 2 == 0) {
                    result = Math.max(result, Math.abs(s1.peek() - logs[i]));
                    s1.push(logs[i]);
                } else {
                    result = Math.max(result, Math.abs(s2.peek() - logs[i]));
                    s2.push(logs[i]);
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

}
