import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] counting = new int[100001];
        int answer = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            while (end < N) {
                if (counting[arr[end]] >= 1) break;

                counting[arr[end]]++;
                end++;
                answer = Math.max(answer, end - i);
            }

            counting[arr[i]]--;
        }

        System.out.println(answer);
    }
}