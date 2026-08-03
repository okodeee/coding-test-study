import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = -1001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (sum < 0) {
                sum = 0;
                continue;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}