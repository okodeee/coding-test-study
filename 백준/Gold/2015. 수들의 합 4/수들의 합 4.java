import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }

        HashMap<Long, Long> map = new HashMap<>();
        long count = 0;

        for (int i = 0; i <= N; i++) {
            count += map.getOrDefault(arr[i] - K, 0L);
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }

        System.out.println(count);
    }
}