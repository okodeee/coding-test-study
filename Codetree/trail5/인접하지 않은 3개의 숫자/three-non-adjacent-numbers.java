import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] LM = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

            LM[i] = max;
        }

        int[] RM = new int[N+1];
        max = 0;
        for (int i = N; i > 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
            } 

            RM[i] = max;
        }

        int answer = 0;
        for (int i = 3; i <= N-2; i++) {
            answer = Math.max(answer, LM[i-2] + arr[i] + RM[i+2]);
        }

        System.out.println(answer);
    }
}