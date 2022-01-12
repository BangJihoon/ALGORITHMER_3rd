package week5;

import java.util.HashSet;

public class 소수찾기 {
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	public static int solution(String numbers) {
		HashSet<Integer> set = new HashSet<Integer>();
	 	permutation("", numbers, set); //순열
	 	return set.size();
	
	} 
	private static void permutation(String prefix, String number, HashSet<Integer> set) {
		for(int i=0;i<number.length();i++) {
			if(isPrime(Integer.parseInt(prefix + number.charAt(i)))) set.add(Integer.parseInt(prefix + number.charAt(i)));
			permutation(prefix + number.charAt(i),number.substring(0, i) + number.substring(i+1, number.length()),set);			
		}
	}
	private static Boolean isPrime(int val) {
		if(val==0 ||val==1) return false; //0,1 은 소수가 아님
		for(int i=2;i<=Math.sqrt(val);i++)
			if(val%i==0) return false;
		return true;
	}
}
