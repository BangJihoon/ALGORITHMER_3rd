package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//57,168 KB 	1212ms
public class 나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int in = Integer.parseInt(tmp.split(" ")[0]);
		int q = Integer.parseInt(tmp.split(" ")[1]);
		Map<Integer,String> map1 = new HashMap<>();
		Map<String,Integer> map2= new HashMap<>();
		for(int i=1;i<=in;i++) {
			String tt = br.readLine();
			map1.put(i,tt);
			map2.put(tt,i);
		}
		String x;
		for(int i=0;i<q;i++) {
			x = br.readLine();
			if(Character.isDigit(x.charAt(0)))
				System.out.println(map1.get(Integer.parseInt(x)));
			else
				System.out.println(map2.get(x));
		}
		br.close();
	}
}
/*
// Map1개 - value값으로 Key찾기 함수, 시간초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int in = Integer.parseInt(tmp.split(" ")[0]);
		int q = Integer.parseInt(tmp.split(" ")[1]);
		Map<Integer,String> map = new HashMap<>();
		for(int i=1;i<=in;i++) {
			map.put(i,br.readLine());
		}
		String x;
		for(int i=0;i<q;i++) {
			x = br.readLine();
			if(Character.isDigit(x.charAt(0)))
				System.out.println(map.get(Integer.parseInt(x)));
			else
				System.out.println(getKey(map, x));
		}
	}
	private static int getKey(Map<Integer,String> map, String value) {
		for(int i : map.keySet())
			if(map.get(i).equals(value))
				return i;
		return 0;
	}
}


 */


