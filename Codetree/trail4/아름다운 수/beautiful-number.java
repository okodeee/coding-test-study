import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        beautiful(N, 0);

        System.out.println(count);
    }

    static void beautiful(int len, int curr) {
        if (len <= curr) {
            if (len == curr) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            beautiful(len, curr + i);
        }
    }
}