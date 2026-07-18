import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            String command = st.nextToken();
            if (command.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                m.put(k, v);

            } else if (command.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                if (m.containsKey(k)) {
                    System.out.println(m.get(k));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                m.remove(k);
            }
        }
    }
}