package week6;

public class 타겟넘버 {
    static int answer=0;
	public static void dfs(int[] numbers, int target, int result, int i) {
		if(i==numbers.length && result==target) {
			answer++;
			return;
		}
		if(i<numbers.length) {
			dfs(numbers,target,result+numbers[i],i+1);
			dfs(numbers,target,result-numbers[i],i+1);
		}
			
	}
	public int solution(int[] numbers, int target) {
		dfs(numbers,target,+numbers[0],1);
		dfs(numbers,target,-numbers[0],1);
    	return answer;
    }
}
