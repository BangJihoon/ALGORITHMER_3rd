package week3;

public class 순위검색_오답1 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		for(int i : solution(info, query))
			System.out.println(i);
	}
	
    public static int[] solution(String[] info, String[] query) {
    	int[] answer = new int[query.length];
    	String[][] sup = new String[info.length][5];
    	for(int i=0;i<info.length;i++) // 지원자 점수와 정보 담기
    		for(int j=0;j<5;j++) sup[i][j] = info[i].split(" ")[j];    		
    	for(int i=0;i<query.length;i++) {
    		query[i] = query[i].replaceAll(" and "," ");
    		String[] qry = query[i].split(" ");
    		answer[i] = ResultCount(sup,qry);
    	}
        return answer;
    }
    
    public static int ResultCount(String[][] sup, String[] qry) {
    	int res=0;
    	Boolean flag;
    	for(int i=0;i<sup.length;i++) {
    		flag=true;
    		for(int j=0;j<5;j++) {
    			if(qry[j].equals("-"))
    				continue;
    			else {
    				if(j==4) { // 마지막 컬럼인 스코어는 크거나 같으면 해당됨
    					if(Integer.parseInt(sup[i][j]) >=  Integer.parseInt(qry[j])) 
    						break;
    				}
    				if(!qry[j].equals(sup[i][j])) {
    					flag=false;
    					break;
    				}
    			}
    		}
    		if(flag) res++;
    	}
    	return res;
    }
}

