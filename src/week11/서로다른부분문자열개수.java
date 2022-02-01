package week11;

import java.util.HashSet;
import java.util.Scanner;
//229,840 KB 	880ms
public class 서로다른부분문자열개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<s.length();i++) 
			for(int j=i;j<s.length();j++) 
				set.add(s.substring(i,j+1));
		System.out.println(set.size());
		sc.close();
	}
}
