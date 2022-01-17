package week9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 완주하지못한선수 {
	/*
	 정확성  테스트
	테스트 1 〉	통과 (0.05ms, 72.5MB)
	테스트 2 〉	통과 (0.06ms, 72.7MB)
	테스트 3 〉	통과 (0.45ms, 84.4MB)
	테스트 4 〉	통과 (1.09ms, 82.4MB)
	테스트 5 〉	통과 (0.81ms, 77.9MB)
	효율성  테스트
	테스트 1 〉	통과 (26.48ms, 83.2MB)
	테스트 2 〉	통과 (58.30ms, 88.5MB)
	테스트 3 〉	통과 (85.65ms, 97MB)
	테스트 4 〉	통과 (53.92ms, 95.7MB)
	테스트 5 〉	통과 (75.61ms, 94.4MB)

	 * */
	public static String solution(String[] participant, String[] completion) {
		HashMap<String,Integer> map = new HashMap<>();
		for(String s : completion) map.put(s, map.getOrDefault(s, 0)+1);
		for(String s : participant) {
			if(!map.containsKey(s)) return s;
			else{
				if(map.get(s) > 0) 
					map.put(s, map.get(s)-1);
				else
					return s;
			}
		}
       return "";
   }
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String ans = solution(participant, completion);
		System.out.println(ans);
	}    
	
	public static String solution_withArray(String[] participant, String[] completion) {
		/*
		정확성  테스트
		테스트 1 〉	통과 (12.02ms, 78.8MB)
		테스트 2 〉	통과 (12.27ms, 76.2MB)
		테스트 3 〉	통과 (12.84ms, 77.9MB)
		테스트 4 〉	통과 (14.42ms, 83.7MB)
		테스트 5 〉	통과 (13.94ms, 87.1MB)
		효율성  테스트
		테스트 1 〉	통과 (149.44ms, 84MB)
		테스트 2 〉	통과 (263.91ms, 89.2MB)
		테스트 3 〉	통과 (361.44ms, 94.9MB)
		테스트 4 〉	통과 (308.02ms, 95.3MB)
		테스트 5 〉	통과 (340.47ms, 96.5MB)
	*/
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++) {
        	if(!participant[i].equals(completion[i])) {
        		System.out.println(participant[i] +" "+completion[i]);
        		return participant[i];
        	}
        }
        return participant[participant.length-1];
    }
	public static String solution_hashset(String[] participant, String[] completion) {
        // set은 동명이인에 대한 count가 필요하므로 풀이 불가능
		HashSet<String> set = new HashSet<String>();
		for(String s : completion) set.add(s);
		for(String s : participant) if(!set.remove(s)) return s;
        return "";
    }	
    
	
}
