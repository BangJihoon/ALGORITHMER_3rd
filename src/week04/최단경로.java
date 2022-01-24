


package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로{
    static int v,e,k;
    static ArrayList<Node> list[];
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");
        v = Integer.parseInt(t[0]);
        e = Integer.parseInt(t[1]);
        dist = new int[v+1];
        list = new ArrayList[v+1];
        for(int i=1; i<=v; i++) 
            list[i] = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        k = Integer.parseInt(br.readLine());    // 시작번호
        dist[k]=0;
        
        for(int i=0; i<e; i++) {
            String [] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);    
            int b = Integer.parseInt(tt[1]);    
            int w = Integer.parseInt(tt[2]);    
            list[a].add(new Node(b,w));
        }
        solve();
        
        for(int i=1; i<=v; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }        
    }
    public static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();        
        pq.add(new Node(k,0)); 		// 시작점에 거리값을 0으로 넣고
        while(!pq.isEmpty()) {
            Node a = pq.poll(); 				// 뺴서 시작!
            for(Node o : list[a.idx]) { 		// 기준점에 저장된 노드값을 가져옴
            	if(dist[o.idx] > dist[a.idx]+o.w) { 
                    dist[o.idx] = dist[a.idx]+o.w;
                    pq.add(new Node(o.idx,dist[o.idx]));
                }   
            }
        }
    }
}

// 정렬되는 우선순위 큐에 이용하기위해서는 사용할 클래스에 compareTo 메소드를 구현해야한다.
class Node implements Comparable<Node>{
    int idx,w;
    Node(int idx,int w){
        this.idx=idx;
        this.w=w;
    }
    public int compareTo(Node o) {
        return this.w-o.w;
    }
}