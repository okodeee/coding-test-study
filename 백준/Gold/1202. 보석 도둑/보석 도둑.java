import java.io.*;
import java.util.*;

public class Main {
    static class Gem {
        int weight;
        int value;

        Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(gems, (o1, o2) -> o1.weight - o2.weight);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int gemIdx = 0;

        for (int i = 0; i < K; i++) {
            while (gemIdx < N && gems[gemIdx].weight <= bags[i]) {
                pq.offer(gems[gemIdx].value);
                gemIdx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}