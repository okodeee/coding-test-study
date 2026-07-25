import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] B = new char[N+1];
        for (int i = 1; i <= N; i++) {
            B[i] = br.readLine().charAt(0);
        }

        int[] LH = new int[N+2];
        int[] RH = new int[N+2];
        int[] LS = new int[N+2];
        int[] RS = new int[N+2];
        int[] LP = new int[N+2];
        int[] RP = new int[N+2];

        for (int i = 1; i <= N; i++) {
            if (B[i] == 'H') { // 주먹
                LP[i] = LP[i-1] + 1;
                LH[i] = LH[i-1];
                LS[i] = LS[i-1];
            } else if (B[i] == 'S') {  // 가위
                LH[i] = LH[i-1] + 1;
                LP[i] = LP[i-1];
                LS[i] = LS[i-1];
            } else if (B[i] == 'P') {  // 보
                LS[i] = LS[i-1] + 1;
                LP[i] = LP[i-1];
                LH[i] = LH[i-1];
            }
        }

        for (int i = N; i > 0; i--) {
            if (B[i] == 'H') { // 주먹
                RP[i] = RP[i+1] + 1;
                RH[i] = RH[i+1];
                RS[i] = RS[i+1];
            } else if (B[i] == 'S') {  // 가위
                RH[i] = RH[i+1] + 1;
                RP[i] = RP[i+1];
                RS[i] = RS[i+1];
            } else if (B[i] == 'P') {  // 보
                RS[i] = RS[i+1] + 1;
                RH[i] = RH[i+1];
                RP[i] = RP[i+1];
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {  // i번부터 바뀜
            answer = Math.max(LP[i-1] + RH[i], answer);
            answer = Math.max(LP[i-1] + RS[i], answer);
            answer = Math.max(LS[i-1] + RH[i], answer);
            answer = Math.max(LS[i-1] + RP[i], answer);
            answer = Math.max(LH[i-1] + RS[i], answer);
            answer = Math.max(LH[i-1] + RP[i], answer);
        }

        System.out.println(answer);
    }
}