import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] diff = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            int curr = Integer.parseInt(st.nextToken());
            diff[i] = curr - pre;
            pre = curr;
        }

        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}