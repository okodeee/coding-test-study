import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }

        int[] R = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] == ')' && arr[i+1] == ')') {
                R[i] = R[i+1] + 1;
            } else {
                R[i] = R[i+1];
            }
        }

        long answer = 0;
        for (int i = 0; i < N - 3; i++) {
            if (arr[i] == '(' && arr[i+1] == '(') {
                answer += R[i+2];
            }
        }
        System.out.println(answer);
    }
}