import java.io.*;
import java.util.*;

public class Main {
    static int[] sequence;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        makeSequence(N, 0);
    }

    static void makeSequence(int length, int index) {
        if (found) return;

        if (length == index) {
            StringBuilder sb = new StringBuilder();

            for (int num : sequence) {
                sb.append(num);
            }

            System.out.println(sb);
            found = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sequence[index] = i;

            if (isGood(index)) {
                makeSequence(length, index + 1);
            }
        }
    }

    static boolean isGood(int index) {
        for (int i = 1; 2 * i <= index + 1; i++) {
            int[] first = Arrays.copyOfRange(sequence, index - 2 * i + 1, index - i + 1);
            int[] second = Arrays.copyOfRange(sequence, index - i + 1, index + 1);

            if (Arrays.toString(first).equals(Arrays.toString(second))) {
                return false;
            }
        }

        return true;
    }
}
