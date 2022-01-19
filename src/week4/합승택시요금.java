package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {
    public static void main(String[] args) {
    	int n = 6; 
    	int s = 4;
    	int a = 6;
    	int b = 2;
    	int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    	System.out.println(solution(n, s, a, b, fares));
	}
    static ArrayList<Path> [] list;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
		// 인접리스트 초기화
    	list = new ArrayList[n+1];
		for(int i=1;i<list.length;i++) 
			list[i] = new ArrayList<Path>();
		for(int[] fare : fares) {
			int c = fare[0];
			int d = fare[1];
			int f = fare[2];
			list[c].add(new Path(d,f)); // 양방향으로 데이터를 넣자		
			list[d].add(new Path(c,f));
		}
		// 거리비용 초기화
		int dist[] = new int[n+1];
		int distA[] = new int[n+1];
		int distB[] = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(distA, Integer.MAX_VALUE);
		Arrays.fill(distB, Integer.MAX_VALUE);

		dist = dijkstra(s,dist);
		distA = dijkstra(a,distA);
		distB = dijkstra(b,distB);
		
		int answer = dist[a] + dist[b];
		for(int i=1;i<dist.length;i++) 
			answer = Math.min(answer,(dist[i]+distA[i]+distB[i]) );
		return answer;
    }
    private static int[] dijkstra(int s,int[] cost) {
    	// 최단비용 cost[] 초기화
    	cost[s] = 0;
    	PriorityQueue<Path> pq = new PriorityQueue<Path>();
    	pq.add(new Path(s,0));
    	while(!pq.isEmpty()) {
    		Path now = pq.poll();
    		for(Path next : list[now.i]) {
    			if(cost[next.i] > now.v + next.v) {
    				cost[next.i] = now.v + next.v; 
    				pq.add(new Path(next.i, cost[next.i]));
    			}
    		}
    	}
    	return cost;
	
    }
}
class Path implements Comparable<Path>{
	int i;
	int v;
	public Path(int i,int v) {
		this.i = i;
		this.v = v;	
	}
	@Override
	public int compareTo(Path p) {
		return this.v - p.v;
	}
}

