package week03;

import java.util.HashSet;
import java.util.Scanner;

public class 수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++)
			set.add(sc.nextInt());
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			if(set.contains(sc.nextInt()))
				System.out.println(1);
			else System.out.println(0);
		}
		sc.close();
	}   
}
