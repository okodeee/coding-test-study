import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> m = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                m.put(k, v);

            } else if (command.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                m.remove(k);

            } else if (command.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                
                if (m.containsKey(k)) {
                    sb.append(m.get(k)).append('\n');
                } else {
                    sb.append("None\n");
                }
            } else if (command.equals("print_list")) {    
                if (!m.isEmpty()) {            
                    Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        sb.append(m.get(entry.getKey())).append(' ');
                    }

                    sb.append('\n');
                } else {
                    sb.append("None\n");
                }
            }
        }

        System.out.println(sb);
    }
}