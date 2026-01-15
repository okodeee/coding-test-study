import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 2];  // 석순 (아래에서 올라옴)
        int[] top = new int[H + 2];     // 종유석 (위에서 내려옴)

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            // 차분 배열 방식으로 계산
            if (i % 2 == 0) {   // 석순
                bottom[1]++;           // 1부터 시작
                bottom[height + 1]--;  // height+1부터는 없음
            } else {    // 종유석
                top[H - height + 1]++;  // H-height+1부터 시작
                top[H + 1]--;           // H+1부터는 없음
            }
        }

        // 누적 합으로 실제 장애물 개수 계산
        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i - 1];
            top[i] += top[i - 1];
        }

        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        // 각 높이별로 장애물 개수 계산
        for (int i = 1; i <= H; i++) {
            int obstacles = bottom[i] + top[i];

            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }

        System.out.println(minObstacles + " " + count);
    }
}