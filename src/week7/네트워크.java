package week7;

public class 네트워크{
    static int ans=0;		
	public static void bfs(int i, int[][] computers) {
		computers[i][i]=0;
		for(int j=0;j<computers.length;j++) {
			if(computers[i][j]==1) {
				computers[i][j]=0;
				bfs(j,computers);
			}
		}
		
	}
	public int solution(int n, int[][] computers) {
		for(int i=0;i<n;i++) {
			if(computers[i][i]==1) {
				ans+=1;
				bfs(i,computers);
			}
		}		
		return ans;  
	}
}
