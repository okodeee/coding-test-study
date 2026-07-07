import java.util.*;
import java.io.*;

public class Main {
    static int K;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        choose(0, N, new int[N]);
    }

    static void choose(int curr, int len, int[] arr) {
        if (curr >= len) {
            print(arr);
            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[curr] = i;
            choose(curr + 1, len, arr);
            arr[curr] = 0;
        }
    }

    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}