import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(s.size());
    }
}