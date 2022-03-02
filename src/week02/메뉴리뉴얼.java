package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {
	/*
	 *  order string을 순회하면서 , course 숫자별로 조합을 만든다.
	 *  해당 조합의 주문숫자를 count해주고, 제일 높은 메뉴를 뽑는다 (동률이면 한개가 아닐수 있음)
	 *  뽑힌 메뉴들 넣은 배열을 알파벳순으로 정렬하여 반환한다.
	 */
	 
	public static void main(String[] args) {
		//String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		String[] ans = solution(orders, course);
		for(String s : ans)
			System.out.println(s);
	}
	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int combi : course) {
			map.clear();
			for(String order : orders) {
				boolean[] visited = new boolean[order.length()];
				combination(map, order, visited, order.length(), 0, combi);
			}
			List<Map.Entry<String,Integer>> entryset = new LinkedList<>(map.entrySet());
			entryset.sort(((o1,o2)-> map.get(o2.getKey())-map.get(o1.getKey())));
			int max=2;
			for(Map.Entry<String, Integer> entry: entryset) {
				if(entry.getValue()>=max) {
					list.add(entry.getKey());
					max = entry.getValue();
				}
			}
			Collections.sort(list);
		}	
		String[] answer = list.toArray(new String[list.size()]);
		return answer;
	}
	static void combination(HashMap<String,Integer> map,String arr, boolean[] visited, int n, int start, int r) {
		if (r == 0) {
			String s="";
        	for(int i=0;i<n;i++) if(visited[i]) s=s.concat(Character.toString(arr.charAt(i))); 
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars);
        	s = new String(chars);
        	map.put(s,map.getOrDefault(s, 0)+1);
        	return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(map,arr, visited, n, i+1, r-1);
            visited[i] = false;
        }
    }	

	
}
