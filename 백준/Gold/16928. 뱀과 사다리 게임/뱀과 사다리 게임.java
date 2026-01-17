import java.io.*;
import java.util.*;


public class Main {

    static boolean[] visited = new boolean[101];
    static int[] path = new int[101];
    static int[] ladder = new int[101];
    static int[] snake = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs(1); // 1번 칸에서 시작

        System.out.println(path[100]);
    }

    static void bfs(int position) {
        visited[position] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(position);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 1; i <= 6; i++) {  // 주사위 이동
                int next = curr + i;

                if (next > 100) continue;

                // 사다리나 뱀이 있으면 최종 위치로 이동
                if (ladder[next] > 0) {
                    next = ladder[next];
                } else if (snake[next] > 0) {
                    next = snake[next];
                }

                // 최종 위치를 방문하지 않았으면 처리
                if (!visited[next]) {
                    path[next] = path[curr] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}