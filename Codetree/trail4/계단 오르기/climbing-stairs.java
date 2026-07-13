import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        int[] answer = new int[N + 1];
        answer[2] = answer[3] = 1;
        for (int i = 4; i <= N; i++) {
            answer[i] = (answer[i-3] + answer[i-2]) % 10007;
        }

        System.out.println(answer[N]);
    }
}