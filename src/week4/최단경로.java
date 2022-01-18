package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class 최단경로 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int input[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		
			int start = Integer.parseInt(br.readLine());
			int[] ans = new int[input[0]];
			int lines[][] = new int[input[1]][3];
			for(int i=0;i<input[1];i++) {
				lines[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(lines[i][0]+" "+lines[i][1]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
