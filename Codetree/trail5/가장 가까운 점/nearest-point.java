import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // @Override
    // public int compareTo(Pair p) {
    //     if ((this.x + this.y) - (p.x + p.y) == 0) {
    //         return this.x - p.x;
    //     } else {
    //         return (this.x + this.y) - (p.x + p.y);
    //     }
    // }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if ((o1.x + o1.y) - (o2.x + o2.y) == 0) {
                return o1.x - o2.x;
            } else {
                return (o1.x + o1.y) - (o2.x + o2.y);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            pq.offer(new Pair(x, y));
        }

        for (int i = 0; i < M; i++) {
            Pair p = pq.poll();
            p.x += 2;
            p.y += 2;

            pq.offer(p);
        }

        Pair p = pq.poll();
        System.out.println(p.x + " " + p.y);
    }
}