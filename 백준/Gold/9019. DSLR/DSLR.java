import java.io.*;
import java.util.*;


public class Main {
    static class State {
        int num;
        String command;

        State(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(bfs(A, B));
        }
    }

    static String bfs(int a, int b) {
        boolean[] visited = new boolean[10000];
        Queue<State> q = new LinkedList<>();

        visited[a] = true;
        q.offer(new State(a, ""));

        while(!q.isEmpty()) {
            State current = q.poll();

            if (current.num == b) {
                return current.command;
            }

            // D 연산
            int next = (current.num * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new State(next, current.command + "D"));
            }

            // S 연산
            next = current.num - 1;
            if (next == -1) next = 9999;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new State(next, current.command + "S"));
            }

            // L 연산
            next = current.num * 10;
            next += (next / 10000);
            next = next % 10000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new State(next, current.command + "L"));
            }

            // R 연산
            next = current.num + (current.num % 10) * 10000;
            next /= 10;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new State(next, current.command + "R"));
            }
        }

        return "";
    }
}