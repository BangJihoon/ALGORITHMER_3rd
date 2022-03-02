package week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/*
	속한 노래가 많이 재생된 장르를 먼저 수록합니다.
	장르 내에서 많이 재생된 노래를 먼저 수록합니다.
	장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
	
정확성  테스트
	테스트 1 〉	통과 (4.48ms, 73.8MB)
	테스트 2 〉	통과 (4.40ms, 78.1MB)
	테스트 3 〉	통과 (3.47ms, 77.1MB)
	테스트 4 〉	통과 (5.78ms, 79.5MB)
	테스트 5 〉	통과 (4.12ms, 76.1MB)
	테스트 6 〉	통과 (18.98ms, 85.7MB)
	테스트 7 〉	통과 (3.24ms, 70.2MB)
	테스트 8 〉	통과 (4.17ms, 82.1MB)
	테스트 9 〉	통과 (3.87ms, 67.9MB)
	테스트 10 〉	통과 (3.32ms, 76.9MB)
	테스트 11 〉	통과 (3.75ms, 74.4MB)
	테스트 12 〉	통과 (4.65ms, 76.4MB)
	테스트 13 〉	통과 (3.55ms, 75.6MB)
	테스트 14 〉	통과 (3.60ms, 76.8MB)
	테스트 15 〉	통과 (3.31ms, 76.7MB)

*/
public class 베스트앨범 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] res = solution(genres, plays);
		for(int i : res)
			System.out.println(i);
	}

    public static int[] solution(String[] genres, int[] plays) {
    	Map<String , Integer> map = new HashMap<>();
    	ArrayList<Song> Songlist = new ArrayList<>();
    	
    	// 장르별 plays수 저장, 곡정보 저장
    	for(int i=0;i<plays.length;i++) {
    		map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
    		Songlist.add(new Song(genres[i] ,i ,plays[i]));
    	}
    	// 장르별 최댓값 정렬
    	ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
    	entryList.sort((Entry<String, Integer> o1, Entry<String, Integer> o2) -> o2.getValue() - o1.getValue());
    	// Song 정렬 (낮은번호 정렬후, 높은 Play수로 정렬)
    	Songlist.sort((o1,o2) -> o1.i - o2.i);
    	Songlist.sort((o1,o2) -> o2.p - o1.p);
    	// 해당 장르에 Best곡 2개 선정
    	ArrayList<Integer> list = new ArrayList<>();
    	for(Map.Entry<String, Integer> entry : entryList) {
    		int cnt=0;
    		for(Song s : Songlist) {
    			if(s.g.equals(entry.getKey())) {
    				list.add(s.i);
    				cnt++;
    			}
    			if(cnt==2) break;
    		}
    	}
    	return list.stream().mapToInt(i->i).toArray();
    }
}
class Song{
	String g;
	int i,p; // g는 장르, i는 곡 번호, p는 play횟수
	public Song(String g, int i, int p) {
		this.g = g;
		this.i = i;
		this.p = p;
	}
}
