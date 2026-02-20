import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[N];
        int[] counts = new int[21];
        long answer = 0L;
        for (int i = 0; i < N; i++) {
            students[i] = br.readLine().length();
            answer += counts[students[i]];

            // 범위 재구성
            if (i - K >= 0) {
                counts[students[i - K]]--;
            }
            counts[students[i]]++;
        }


        System.out.println(answer);
    }
}
