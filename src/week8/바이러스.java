package week8;
import java.util.Arrays;
import java.util.Scanner;


// 18,040KB , 244ms
public class 바이러스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int com = sc.nextInt();
		int idx = sc.nextInt();
		int networks[][] = new int[idx][2]; 
		for(int i=0;i<idx;i++) {
			networks[i][0] = sc.nextInt();
			networks[i][1] = sc.nextInt();
		}
		Boolean flag[] = new Boolean[com];
		Arrays.fill(flag, false);
		dfs(1,flag,networks);
		int ans=0;
		for(Boolean a : flag)
			if(a) ans++;
		System.out.println(ans-1);
		sc.close();
	}
	private static void dfs(int idx, Boolean[] flag,int networks[][]) {
		flag[idx-1] = true;
		for(int i=0;i<networks.length;i++) {
			if(!flag[networks[i][1]-1] && networks[i][0] == idx) dfs(networks[i][1],flag, networks);
			if(!flag[networks[i][0]-1] && networks[i][1] == idx) dfs(networks[i][0],flag, networks);
		}
	}
}
