import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                pq.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                sb.append(pq.poll()).append('\n');
            } else if (command.equals("size")) {
                sb.append(pq.size()).append('\n');
            } else if (command.equals("empty")) {
                if (pq.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("top")) {
                sb.append(pq.peek()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
