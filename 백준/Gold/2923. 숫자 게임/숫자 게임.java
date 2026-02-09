import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 각 숫자의 빈도를 저장
        int[] countA = new int[100];
        int[] countB = new int[100];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            countA[a]++;
            countB[b]++;

            sb.append(calculateMinMax(countA, countB)).append("\n");
        }

        System.out.println(sb);
    }

    private static int calculateMinMax(int[] countA, int[] countB) {
        int max_sum = 0;

        int[] tempB = countB.clone();

        int currB = 99; // B는 큰 숫자부터 탐색

        // A는 작은 숫자부터 탐색
        for (int currA = 1; currA < 100; currA++) {
            if (countA[currA] == 0) continue;

            int numA = countA[currA]; // 현재 A 숫자의 개수

            while (numA > 0) {
                // 매칭할 B 숫자가 있는 곳까지 포인터 이동
                while (currB > 0 && tempB[currB] == 0) {
                    currB--;
                }

                // 현재 A와 매칭할 수 있는 B의 개수 결정
                int take = Math.min(numA, tempB[currB]);

                // 합의 최댓값 갱신
                max_sum = Math.max(max_sum, currA + currB);

                numA -= take;
                tempB[currB] -= take;
            }
        }

        return max_sum;
    }
}
