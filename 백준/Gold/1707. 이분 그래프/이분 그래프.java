import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main{
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int			   cnt= Integer.parseInt( br.readLine() );	// 테스트 케이스 개수
		
		while( cnt-->0 ) {
			String[]	raw = br.readLine().split(" ");
			int			V	= Integer.parseInt( raw[0] );			// 정점 개수
			int			E	= Integer.parseInt( raw[1] );			// 간선 개수
			
			List<Integer>[] aList	= new ArrayList[V+1];			// 인접리스트
			int[]			check	= new int[V+1];					// check - 얘가 color 역할. => 0 : 방문 x / 1 : 방문했는데 그룹번호 1 / 2: 방문했는데 그룹번호 2 
			boolean			flag	= true;							// 이분그래프 구분 Flag
			
			// 초기화
			for( int j=1;j<=V;j++ ) {
				check[j] = 0;
				aList[j] = new ArrayList<Integer>();
			}
			
			// 값 초기화
			for( int j=0;j<E;j++ ) {
				raw = br.readLine().split(" ");
				int from = Integer.parseInt( raw[0] );
				int to = Integer.parseInt( raw[1] );
				aList[from].add(to);
				aList[to].add(from);
			}
			
			// DFS
			// (1) 그룹번호 부여 작업
			for( int j=1;j<=V;j++ ) {
				if( check[j]==0 ) {
					dfs( aList, check, j, 1 ); // 맨 첨의 그룹번호는 1이기 땜에 1넣음
				}
			}
			
			// (2) 겹치는 그룹번호 구분 작업
			for( int j=1;j<=V;j++ ) {
				for( int k : aList[j] ) {
					if( check[j]==check[k] ) {
						flag = false; 
                        break;
					}
				}
			}
			
			// 이분그래프인지 아닌지 판단
			if( flag ) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	// DFS
	private static void dfs(List<Integer>[] aList, int[] check, int V, int groupNum) {
		check[V] = groupNum;
		
		for( int next : aList[V] ) { // for( int i=0;i<aList[V].size();i++ ) { //foreach로 사용하기!
			if( check[next]==0 ) { // 아직 방문안했으면 재귀
				dfs(aList, check, next, 3-groupNum);
				// 처음엔 1로 들어왔으면 그 다음 번호는 2가 되어야 하니까(2+1=3인 점을 이용)
				// 정점이 똑같은 게 들어오면 번호가 다르게 매겨지겠지..??
			}
		}
	}
    
}