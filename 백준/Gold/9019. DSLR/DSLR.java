import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Value {
        int num;
        String command;

        Value(int n, String c) {
            num = n;
            command = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }

        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        boolean[] visited = new boolean[10000];
        Queue<Value> q = new LinkedList<>();

        visited[a] = true;
        q.offer(new Value(a, ""));

        while (!q.isEmpty()) {
            Value curr = q.poll();

            if (curr.num == b) {
                sb.append(curr.command).append('\n');
                return;
            }

            // D
            int next = (curr.num * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Value(next, curr.command + "D"));
            }

            // S
            next = curr.num - 1;
            if (next == -1) next = 9999;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Value(next, curr.command + "S"));
            }

            // L
            next = curr.num * 10;
            next += (next / 10000);
            next = next % 10000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Value(next, curr.command + "L"));
            }

            // R
            next = curr.num + (curr.num % 10) * 10000;
            next /= 10;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Value(next, curr.command + "R"));
            }
        }
    }
}