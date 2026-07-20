import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                s.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("remove")) {
                s.remove(Integer.parseInt(st.nextToken()));
            } else if (command.equals("find")) {
                sb.append(s.contains(Integer.parseInt(st.nextToken()))).append('\n');
            }
        }

        System.out.println(sb);
    }
}