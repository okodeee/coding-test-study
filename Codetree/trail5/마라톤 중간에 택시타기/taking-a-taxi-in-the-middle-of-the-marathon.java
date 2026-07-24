import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][2];
        int[] L = new int[N+1];
        int[] R = new int[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            L[i] = L[i-1] + Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
        }

        for (int i = N-1; i > 0; i--) {
            R[i] = R[i+1] + Math.abs(arr[i+1][0] - arr[i][0]) + Math.abs(arr[i+1][1] - arr[i][1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 2; i < N; i++) {
            int dis = L[i-1] + Math.abs(arr[i-1][0] - arr[i+1][0]) + Math.abs(arr[i-1][1] - arr[i+1][1]) + R[i+1];
            answer = Math.min(answer, dis);
        }

        System.out.println(answer);
    }
}