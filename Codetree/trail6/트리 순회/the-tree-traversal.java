import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[] leftNum;
    static char[] rightNum;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        leftNum = new char[26];
        rightNum = new char[26];
        
        // 자식이 없는 경우 초기값 '.'
        Arrays.fill(leftNum, '.');
        Arrays.fill(rightNum, '.');

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            // 부모 문자(p)에서 'A'를 뺀 값을 배열의 인덱스(0~25)로 사용
            int index = p - 'A';
            leftNum[index] = l;
            rightNum[index] = r;
        }

        sb = new StringBuilder(); 
        
        pre('A');
        sb.append("\n");
        mid('A');
        sb.append("\n");
        post('A');
        
        System.out.print(sb);
    }

    // 전위 순회 (Root -> Left -> Right)
    static void pre(char current) {
        if (current == '.') return;
        
        sb.append(current);
        int index = current - 'A';
        pre(leftNum[index]);
        pre(rightNum[index]);
    }

    // 중위 순회 (Left -> Root -> Right)
    static void mid(char current) {
        if (current == '.') return;
        
        int index = current - 'A';
        mid(leftNum[index]);
        sb.append(current);
        mid(rightNum[index]);
    }

    // 후위 순회 (Left -> Right -> Root)
    static void post(char current) {
        if (current == '.') return;
        
        int index = current - 'A';
        post(leftNum[index]);
        post(rightNum[index]);
        sb.append(current);
    }
}