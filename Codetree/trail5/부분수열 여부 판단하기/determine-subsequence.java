import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        // B의 원소를 기준으로 순서대로 매칭이 가능한지 확인
        int i = 0;
        for (int j = 0; j < M; j++) {
            while (i < N && A[i] != B[j]) i++;

            // 부분수열 아님
            if (i >= N) {
                answer = -1;
                break;
            } else i++;
        }

        System.out.println(answer == 1 ? "Yes" : "No");
    }
}