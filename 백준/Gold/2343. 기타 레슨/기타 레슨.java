import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int length = 0;
        int[] lectures = new int[N + 1];
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            length += lectures[i];
        }

        int result = length;    // 블루레이 하나의 크기
        int left = 1;
        int right = length;

        while (left <= right) {
            int middle = (left + right) / 2;    // 블루레이의 크기
            int blurayCount = 1;

            int eachLength = 0;
            for (int i = 0; i < N; i++) {
                if (eachLength + lectures[i] <= middle) {
                    eachLength += lectures[i];
                } else {
                    blurayCount++;
                    eachLength = lectures[i];
                    // 각 강의는 블루레이 크기를 벗어나면 안 됨
                    if (eachLength > middle) {
                        break;
                    }
                }
            }

            if (blurayCount <= M && eachLength <= middle) {
                result = Math.min(result, middle);
                right = middle - 1;

            } else {
                // 불가능
                left = middle + 1;
            }
        }

        System.out.println(result);
    }
}