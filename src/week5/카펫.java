package week5;

public class 카펫 {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int[] res = solution(brown, yellow);
		System.out.println(res[0]+" "+res[1]);
	}
	public static int[] solution(int brown, int yellow) {
		int[] answer = {0,0};
		int sum = brown+yellow;
		for(int x=2; x<sum; x++) {
			if(sum%x==0) {
				int y= sum/x;
				if((2*x+2*y-4)==brown){
					answer[0]=y;
					answer[1]=x;
					return answer;
		    	}
			}	
			else 
				continue;
		}        
		return answer;
	}	
}
