import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;    // 사용 못 하면 true
            }
        }

        // 100번에서 +/-만 사용
        int minPress = Math.abs(N - 100);

        // 숫자 버튼 누르고 +/- 사용
        for (int channel = 0; channel <= 1000000; channel++) {
            if (pos(channel, broken)) {
                int press = String.valueOf(channel).length() + Math.abs(N - channel);
                minPress = Math.min(minPress, press);
            }
        }

        System.out.println(minPress);
    }

    static boolean pos(int channel, boolean[] broken) {
        if (channel == 0) {
            return !broken[0];
        }

        while (channel > 0) {
            if (broken[channel % 10]) {
                return false;
            }
            channel /= 10;
        }
        return true;
    }
}