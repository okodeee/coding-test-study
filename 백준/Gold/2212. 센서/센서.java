import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        List<Integer> gap = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            gap.add(sensors[i + 1] - sensors[i]); // 센서 사이 간격
        }

        Collections.sort(gap);

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += gap.get(i);
        }

        System.out.println(result);
    }
}