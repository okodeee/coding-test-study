import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] snowballs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snowballs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snowballs);

        int result = Integer.MAX_VALUE;

        // 첫 번째 눈사람을 고정 (i, j)
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowman1 = snowballs[i] + snowballs[j];

                // 두 번째 눈사람을 투포인터로 찾기
                int left = 0;
                int right = N - 1;

                while (left < right) {
                    // 이미 사용한 눈덩이 제외
                    if (left == i || left == j) {
                        left++;
                        continue;
                    }
                    if (right == i || right == j) {
                        right--;
                        continue;
                    }

                    int snowman2 = snowballs[left] + snowballs[right];

                    result = Math.min(Math.abs(snowman1 - snowman2), result);

                    // 투포인터 이동
                    if (snowman2 < snowman1) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        System.out.println(result);
    }
}