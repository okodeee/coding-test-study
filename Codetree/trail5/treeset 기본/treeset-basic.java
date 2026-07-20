import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> s = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                s.add(x);
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                s.remove(x);
            } else if (command.equals("find")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(s.contains(x)).append('\n');
            } else if (command.equals("lower_bound")) {
                int x = Integer.parseInt(st.nextToken());

                if (s.ceiling(x) == null) {
                    sb.append("None").append('\n');
                } else {
                    sb.append(s.ceiling(x)).append('\n');
                }
            } else if (command.equals("upper_bound")) {
                int x = Integer.parseInt(st.nextToken());
                
                if (s.higher(x) == null) {
                    sb.append("None").append('\n');
                } else {
                    sb.append(s.higher(x)).append('\n');
                }
            } else if (command.equals("largest")) {               
                if (s.isEmpty()) {
                    sb.append("None").append('\n');
                } else {
                    sb.append(s.last()).append('\n');
                }
            } else if (command.equals("smallest")) {               
                if (s.isEmpty()) {
                    sb.append("None").append('\n');
                } else {
                    sb.append(s.first()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}