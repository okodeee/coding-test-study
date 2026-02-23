import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(books);

        // 음수 위치 책 정돈
        int result = 0;
        int index = 0;
        int organized = 0;
        while (books[index] < 0) {
            result += Math.abs(books[index]) * 2;

            int i = M;
            while (index < N && i-- > 0 && books[index] < 0) {
                index++;
                organized++;
            }

            if (organized == N) {
                result -= Math.abs(books[0]);
                System.out.println(result);
                return;
            }
        }

        // 양수 위치 책 정돈
        index = N - 1;
        while (books[index] > 0) {
            result += books[index] * 2;

            int i = M;
            while (index >= 0 && i-- > 0 && books[index] > 0) {
                index--;
                organized++;
            }

            if (organized == N) {
                result -= Math.max(Math.abs(books[0]), Math.abs(books[N - 1]));
                System.out.println(result);
                return;
            }
        }
    }
}