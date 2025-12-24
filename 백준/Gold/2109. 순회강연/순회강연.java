import java.io.*;
import java.util.*;


public class Main {

    static class Lesson {

        int payment;
        int date;

        Lesson(int p, int d) {
            this.payment = p;
            this.date = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 날짜 오름차순
        PriorityQueue<Lesson> pq = new PriorityQueue<>(
            (o1, o2) -> o2.date - o1.date
        );

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new Lesson(p, d));
        }

        PriorityQueue<Lesson> ppq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1.payment == o2.payment) {
                    return o2.date - o1.date;
                }
                return o2.payment - o1.payment;
            }
        );
        int result = 0;
        for (int day = n; day > 0; day--) {
            while (!pq.isEmpty() && pq.peek().date >= day) {
                ppq.offer(pq.poll());
            }

            if (!ppq.isEmpty()) {
                result += ppq.poll().payment;
            }
        }

        System.out.println(result);
    }
}