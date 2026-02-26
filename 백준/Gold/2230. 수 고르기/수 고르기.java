import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[j] - arr[i] >= M) {
                    result = Math.min(result, arr[j] - arr[i]);
                    break;
                }
            }
        }

        System.out.println(result);
    }
}