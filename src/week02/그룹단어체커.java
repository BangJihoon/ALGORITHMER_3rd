package week02;

import java.util.HashSet;
import java.util.Scanner;

public class 그룹단어체커{
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ans = n;
		for(int i=0;i<n;i++) {
			String str = sc.next();
			checkFunc(str);
		}
		sc.close();
		System.out.println(ans);
	}
	private static void checkFunc(String str) {
		HashSet<Character> set = new HashSet<>();
		char ch = str.charAt(0);
		set.add(ch);
		for(int i=0;i<str.length();i++) {
			if(ch == str.charAt(i))
				continue;
			else {
				if(set.contains(str.charAt(i))) {
					ans--;
					return;
				}				
				else {
					ch = str.charAt(i);
					set.add(ch);
				}
			}				
		}
	}
}
