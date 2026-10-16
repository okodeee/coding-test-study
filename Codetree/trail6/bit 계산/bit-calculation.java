import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        int curr = 0; // 비트마스크 변수
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("clear")) {
                curr = 0;
                continue;
            }
            
            int x = Integer.parseInt(st.nextToken());

            if (command.equals("add")) {
                curr |= (1 << x);
            } 
            else if (command.equals("delete")) {
                curr &= ~(1 << x);
            } 
            else if (command.equals("print")) {
                System.out.println((curr & (1 << x)) == 0 ? 0 : 1);
            } 
            else if (command.equals("toggle")) {
                curr ^= (1 << x);
            }

        }
    }
}