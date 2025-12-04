import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 회전 초밥 벨트
        int[] sushiBelt = new int[N];
        for (int i = 0; i < N; i++) {
            sushiBelt[i] = Integer.parseInt(br.readLine());
        }


        int[] eatenSushi = new int[d + 1];  // k개를 연속해서 먹을 때의 초밥 종류 별 개수
        int number = 0; // 초밥 가짓수

        // 1. 맨 처음 조합 (회전 초밥 벨트 0번~ k개)
        for (int i = 0; i < k; i++) {
            if (eatenSushi[sushiBelt[i]] == 0) number++;
            eatenSushi[sushiBelt[i]]++;
        }

        // 쿠폰으로 가짓수 추가
        int result = number;
        if (eatenSushi[c] == 0) result++;

        // 2. 하나씩 밀면서 가짓수 세기
        for (int i = 0; i < N - 1; i++) {
            if (eatenSushi[sushiBelt[i]] == 1) number--;
            eatenSushi[sushiBelt[i]]--;

            if (eatenSushi[sushiBelt[(i + k + N) % N]] == 0) number++;
            eatenSushi[sushiBelt[(i + k + N) % N]]++;

            if (eatenSushi[c] == 0) {
                result = Math.max(result, number + 1);
                continue;
            }

            result = Math.max(result, number);
        }

        System.out.println(result);
    }
}