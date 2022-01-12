package week8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class 여행경로 {
static ArrayList<String> answer;
	static Boolean [] visited;
	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>();
		visited = new Boolean[tickets.length+1];
		Arrays.fill(visited, false);
		String ans = "ICN ";
		dfs("ICN",tickets,ans,1);
		Collections.sort(answer);
		return answer.get(0).split(" ");
	}
	private static void dfs(String from, String[][] tickets, String ans,int idx) {
		if(idx==tickets.length+1) {
			answer.add(ans);
			return;
		}
		for(int i=0;i<tickets.length;i++) {
			if(!visited[i] && from.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets[i][1], tickets, ans+tickets[i][1]+" ", idx+1);
				visited[i] = false;
			}
		}
	}
}
/*
		테스트 1 〉	통과 (78.43ms, 106MB)
		테스트 2 〉	통과 (8.62ms, 81.2MB)
		테스트 3 〉	통과 (8.83ms, 79MB)
		테스트 4 〉	통과 (9.02ms, 74.9MB)
 * */
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 여행경로 {
	static ArrayList<String> answer;
	static Boolean [] visited;
	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		여행경로 c1 = new 여행경로();
		String[] answer = c1.solution(tickets);
		for(String a : answer)
			System.out.println(a);
	}
	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>();
		visited = new Boolean[tickets.length+1];
		Arrays.fill(visited, false);
		String ans = "ICN ";
		dfs("ICN",tickets,ans,1);
		Collections.sort(answer);
		return answer.get(0).split(" ");
	}
	private static void dfs(String from, String[][] tickets, String ans,int idx) {
		if(idx==tickets.length+1) {
			answer.add(ans);
			return;
		}
		for(int i=0;i<tickets.length;i++) {
			if(!visited[i] && from.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets[i][1], tickets, ans+tickets[i][1]+" ", idx+1);
				visited[i] = false;
			}
		}
	}
}
*/
