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

        int s = arr[0], e = 0;
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (s > arr[i]) {
                answer = Math.max(answer, e - s);
                s = arr[i];
                e = arr[i];
            } else {
                e = Math.max(e, arr[i]);
            }
        }

        answer = Math.max(answer, e - s);

        System.out.println(answer);
    }
}