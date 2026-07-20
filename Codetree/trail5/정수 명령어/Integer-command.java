import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            TreeSet<Integer> s = new TreeSet<>();
            int K = Integer.parseInt(br.readLine());

            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    s.add(n);
                } else if (command.equals("D")) {
                    int n = Integer.parseInt(st.nextToken());

                    if (!s.isEmpty()) {
                        if (n == 1) {
                            s.remove(s.last());
                        } else if (n == -1) {
                        s.remove(s.first());
                        }
                    }
                }
            }

            if (s.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(s.last()).append(' ').append(s.first()).append('\n');
            }
        }

        System.out.println(sb);
    }
}