import java.io.*;
import java.util.*;

class Node {
    int id;
    Node prev, next;

    public Node(int id) {
        this.id = id;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    // 1번 연산: i번 노드를 기존 리스트에서 완전히 뽑아냄 (단일 노드로 만듦)
    public static void disconnect(Node u) {
        if (u.prev != null) {
            u.prev.next = u.next;
        }
        if (u.next != null) {
            u.next.prev = u.prev;
        }
        u.prev = null;
        u.next = null;
    }

    // 2번 연산: 단일 노드인 j를 i의 앞에 삽입
    public static void insertPrev(Node i, Node j) {
        j.prev = i.prev;
        j.next = i;
        
        if (i.prev != null) {
            i.prev.next = j;
        }
        i.prev = j;
    }

    // 3번 연산: 단일 노드인 j를 i의 뒤에 삽입
    public static void insertNext(Node i, Node j) {
        j.next = i.next;
        j.prev = i;
        
        if (i.next != null) {
            i.next.prev = j;
        }
        i.next = j;
    }

    // 4번 연산 및 전체 출력용 상태 빌더
    public static void printNeighbors(Node u, StringBuilder sb) {
        int prevId = (u.prev != null) ? u.prev.id : 0;
        int nextId = (u.next != null) ? u.next.id : 0;
        sb.append(prevId).append(" ").append(nextId).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < q; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int i = Integer.parseInt(st.nextToken());
                disconnect(nodes[i]);
            } else if (command == 2) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                insertPrev(nodes[i], nodes[j]);
            } else if (command == 3) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                insertNext(nodes[i], nodes[j]);
            } else if (command == 4) {
                int i = Integer.parseInt(st.nextToken());
                printNeighbors(nodes[i], sb);
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int nextId = (nodes[i].next != null) ? nodes[i].next.id : 0;
            sb.append(nextId).append(" ");
        }
        sb.append("\n");
        
        System.out.print(sb);
    }
}
