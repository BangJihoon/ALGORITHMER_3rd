package week4;
/*

정확성  테스트
테스트 1 〉	통과 (1.88ms, 79.7MB)
테스트 2 〉	통과 (0.59ms, 72MB)
테스트 3 〉	통과 (0.90ms, 79.1MB)
테스트 4 〉	통과 (1.15ms, 71.4MB)
테스트 5 〉	통과 (0.72ms, 66.8MB)
테스트 6 〉	통과 (0.99ms, 77.1MB)
테스트 7 〉	통과 (1.23ms, 78.5MB)
테스트 8 〉	통과 (2.15ms, 73.4MB)
테스트 9 〉	통과 (0.95ms, 77.3MB)
테스트 10 〉	통과 (1.27ms, 78MB)
효율성  테스트
테스트 1 〉	통과 (4.11ms, 52.3MB)
테스트 2 〉	통과 (13.26ms, 55.7MB)
테스트 3 〉	통과 (5.75ms, 60.3MB)
테스트 4 〉	통과 (3.91ms, 52.5MB)
테스트 5 〉	통과 (3.16ms, 52.3MB)
테스트 6 〉	통과 (5.78ms, 52.4MB)
테스트 7 〉	통과 (45.40ms, 63.9MB)
테스트 8 〉	통과 (53.79ms, 66.5MB)
테스트 9 〉	통과 (20.65ms, 65.8MB)
테스트 10 〉	통과 (21.38ms, 61.9MB)
테스트 11 〉	통과 (23.44ms, 80.9MB)
테스트 12 〉	통과 (29.96ms, 61.3MB)
테스트 13 〉	통과 (27.22ms, 58.5MB)
테스트 14 〉	통과 (22.35ms, 61.1MB)
테스트 15 〉	통과 (30.08ms, 60.8MB)
테스트 16 〉	통과 (3.46ms, 51.9MB)
테스트 17 〉	통과 (4.37ms, 52.4MB)
테스트 18 〉	통과 (3.81ms, 52.2MB)
테스트 19 〉	통과 (8.61ms, 53MB)
테스트 20 〉	통과 (13.52ms, 55.2MB)
테스트 21 〉	통과 (7.02ms, 53.7MB)
테스트 22 〉	통과 (25.21ms, 58MB)
테스트 23 〉	통과 (34.00ms, 61MB)
테스트 24 〉	통과 (29.38ms, 58.8MB)
테스트 25 〉	통과 (2.81ms, 52.8MB)
테스트 26 〉	통과 (2.70ms, 52.5MB)
테스트 27 〉	통과 (8.99ms, 55MB)
테스트 28 〉	통과 (7.75ms, 54.2MB)
테스트 29 〉	통과 (3.01ms, 52.3MB)
테스트 30 〉	통과 (3.12ms, 52.7MB)

 * */
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

