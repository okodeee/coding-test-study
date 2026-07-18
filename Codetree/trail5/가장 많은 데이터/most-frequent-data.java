import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> m = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            m.put(str, m.getOrDefault(str, 0) + 1);

            answer = Math.max(answer, m.getOrDefault(str, 0));
        }

        System.out.println(answer);
    }
}