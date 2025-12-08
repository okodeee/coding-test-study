import java.io.*;
import java.util.*;


public class Main {
    static int[] capacity = new int[3]; // 각 물통의 최대 용량
    static boolean[][][] visited;
    static TreeSet<Integer> answer = new TreeSet<>();   // 자동 정렬 + 중복 제거

    static class State {    // 물통 상태 표현
        int[] water;    // {a, b, c}

        State(int a, int b, int c) {
            water = new int[]{a, b, c};
        }

        State(int[] water) {
            this.water = water.clone(); // 복사해서 저장
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[capacity[0] + 1][capacity[1] + 1][capacity[2] + 1];
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int value : answer) {
            sb.append(value).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, capacity[2]));
        visited[0][0][capacity[2]] = true;

        while (!q.isEmpty()) {
            State current = q.poll();

            if (current.water[0] == 0) {
                answer.add(current.water[2]);
            }

            // 6가지 물 옮기기
            pourWater(q, current, 0, 1);    // A → B
            pourWater(q, current, 0, 2);    // A → C
            pourWater(q, current, 1, 0);    // B → A
            pourWater(q, current, 1, 2);    // B → C
            pourWater(q, current, 2, 0);    // C → A
            pourWater(q, current, 2, 1);    // C → B
        }

    }

    static void pourWater(Queue<State> queue, State current, int from, int to) {

        // 새로운 상태 배열 생성
        int[] next = current.water.clone();

        // 옮길 수 있는 물의 양
        // = min(출발 물통의 물, 도착 물통의 남은 공간)
        int move = Math.min(next[from], capacity[to] - next[to]);

        // 물 옮기기
        next[from] -= move;
        next[to] += move;

        // 미방문 상태라면 큐에 추가
        if (!visited[next[0]][next[1]][next[2]]) {
            visited[next[0]][next[1]][next[2]] = true;
            queue.offer(new State(next));
        }
    }
}