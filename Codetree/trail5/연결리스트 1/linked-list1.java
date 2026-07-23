import java.io.*;
import java.util.*;

class Node {
    String data;
    Node prev, next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    // 1번 연산: cur의 앞에 새로운 노드 삽입
    public static void insertPrev(Node cur, Node newNode) {
        newNode.prev = cur.prev;
        newNode.next = cur;
        
        if (cur.prev != null) {
            cur.prev.next = newNode;
        }
        cur.prev = newNode;
    }

    // 2번 연산: cur의 뒤에 새로운 노드 삽입
    public static void insertNext(Node cur, Node newNode) {
        newNode.next = cur.next;
        newNode.prev = cur;
        
        if (cur.next != null) {
            cur.next.prev = newNode;
        }
        cur.next = newNode;
    }

    // 현재 노드 상태 출력 함수
    public static void printStatus(Node cur, StringBuilder sb) {
        // 이전 노드 데이터
        if (cur.prev != null) {
            sb.append(cur.prev.data).append(" ");
        } else {
            sb.append("(Null) ");
        }
        
        // 현재 노드 데이터
        sb.append(cur.data).append(" ");
        
        // 다음 노드 데이터
        if (cur.next != null) {
            sb.append(cur.next.data).append("\n");
        } else {
            sb.append("(Null)\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        Node cur = new Node(str);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                String value = st.nextToken();
                Node newNode = new Node(value);
                insertPrev(cur, newNode);
            } else if (command == 2) {
                String value = st.nextToken();
                Node newNode = new Node(value);
                insertNext(cur, newNode);
            } else if (command == 3) {
                if (cur.prev != null) {
                    cur = cur.prev;
                }
            } else if (command == 4) {
                if (cur.next != null) {
                    cur = cur.next;
                }
            }
            
            printStatus(cur, sb);
        }
        
        System.out.print(sb.toString());
    }
}
