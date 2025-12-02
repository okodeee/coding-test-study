import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        // 공유기 사이의 최소 거리를 이분 탐색
        int left = 1;   // 한 집에는 공유기를 하나만 설치
        int right = houses[N - 1] - houses[0];  // 가장 먼 집 - 가장 가까운 집
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(houses, C, mid)) {
                answer = mid;
                left = mid + 1; // 더 먼 거리로 다시 시도
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canInstall(int[] houses, int num, int distance) {
        int count = 1;  // 설치된 공유기 개수 (첫 번째 집에는 무조건 설치)
        int lastInstalled = houses[0];  // 마지막으로 설치한 집의 위치

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];

                // C개를 모두 설치했으면 성공
                if (count >= num) {
                    return true;
                }
            }
        }
        return false;
    }
}