import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] B = new boolean[2*N+1];
        for (int i = 0; i < N; i++) {
            B[Integer.parseInt(br.readLine())] = true;
        }

        // N번의 라운드 진행
        int answer = 0;
        int avail = 0;
        for (int i = 2*N; i > 0; i--) {
            if (!B[i]) avail++;
            else {
                if (avail>0) {
                    answer++;
                    avail--;
                }
            }
        }

        System.out.println(answer);
    }
}