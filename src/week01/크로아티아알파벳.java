package week01;

import java.util.Scanner;
// 백준은 Scanner를 사용하여 표준입력을 직접 넣어보는 함수코드이고
// 프로그래머스는 Main에서 solution 함수를 여러차례 불러보는 형태이다
public class 크로아티아알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  // ljes=njak
		String str = sc.next();
		System.out.println(solution(str));
		sc.close();
	}
	public static int solution(String str) {
		String[] croAlpha = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(String s : croAlpha)
			if(str.contains(s)) str = str.replaceAll(s, "*");
		return str.length();
	}
}
	