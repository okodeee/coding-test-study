import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snow = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snow);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowman1 = snow[i] + snow[j];

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

                    int snowman2 = snow[left] + snow[right];

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
