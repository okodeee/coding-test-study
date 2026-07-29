import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            
            int left = 0;
            int right = N-1;
            int minIdx = N;
            while (left <= right) {
                int mid = (left + right)/2;

                if (arr[mid] > q) {
                    right = mid - 1;
                } else if (arr[mid] < q) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    minIdx = mid;
                }
            }

            sb.append(minIdx == N ? -1 : minIdx + 1).append('\n');
        }

        System.out.println(sb);
    }
}