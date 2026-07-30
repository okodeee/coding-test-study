import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;
            int idx = N;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (points[mid] < s) {
                    left = mid + 1;
                } else if (points[mid] >= s) {
                    right = mid - 1;
                    idx = mid;
                }
            }
            int sIdx = idx;

            left = 0;
            right = N-1;
            idx = -1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (points[mid] <= e) {
                    left = mid + 1;
                    idx = mid;
                } else if (points[mid] > e) {
                    right = mid - 1;
                }
            }
            int eIdx = idx;
            sb.append(eIdx - sIdx + 1).append('\n');
        }
        
        System.out.println(sb);
    }
}