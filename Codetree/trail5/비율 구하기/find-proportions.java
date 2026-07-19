import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> m = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            m.put(str, m.getOrDefault(str, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();

            String k = entry.getKey();
            Integer v = m.get(k);

            sb.append(k).append(' ').append(String.format("%.4f", (double) v * 100 / N)).append('\n');
        }

        System.out.println(sb);
    }
}