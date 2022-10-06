import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int	N = Integer.parseInt(br.readLine());	// 숲 크기
		
		int[][]		FOREST	= new int[N+1][N+1];	// 숲
		int[][]		D 		= new int[N+1][N+1];	// 칸의 수..
		//boolean[][] visit	= new boolean[N+1][N+1];// 판다는 현재칸보다 더 큰 값의 칸으로만 이동하기 때문에 다시 같은 칸을 방문하지 않는다!
		
		/*
		    어떤 지점에 처음에 풀어 놓아야 하는지가 문제에서 나와있어서
            나무가 젤 작은 위치에서부터 시작하면 된다는 생각에
            최소값을 찾으려는 시도를 했음
		*/
		// 값 초기화
		for( int i=0;i<N;i++ ){
			String[] raws = br.readLine().split(" ");
			for( int j=0;j<N;j++ ){
				int value = Integer.parseInt(raws[j]);
				FOREST[i][j] = value;
			}
		}
	    
        // 초기화는 해줄 필요 없었다.    
    
		// DFS - 최대한 깊게 많은 칸을 가야하니까..
		for( int i=0;i<N;i++ ){
			for( int j=0;j<N;j++ ){
				/*
				 * 이것만 하면 안되고 for문도 돌려야 하는 이유가 전체를 다 돌아야하기 때문임.
				 * 안하면은 nX,nY로만 돌기 때문에 부분적으로만 돌 수 있음..
				 */
				answer = Math.max( answer, DFS(N, FOREST, D, i, j) );
			}
		}

		System.out.println(answer);
    }
    
    private static int DFS(int N, int[][] FOREST, int[][] D, int i, int j) {
		// 메모이제이션을 깜빡 했다....
		if( D[i][j]!=0 ){
			return D[i][j]; // 이미 방문한 곳이면 해당 값을 리턴
		}
		
		D[i][j] = 1; // 시작점도 갈 수 있는 방법에 포함하므로
		
		for( int k=0;k<4;k++ ){
			int nX = i + dx[k],
				nY = j + dy[k];

			if( nX>-1&&nX<N&&nY>-1&&nY<N ){
				if( FOREST[i][j]<FOREST[nX][nY] ){ // 방문하지 않았고 현재 값보다 크면
					int nCount = DFS( N, FOREST, D, nX, nY) + 1; // 다음 칸으로 움직일 수 있음을 의미하므로 nX,nY의 다음 인덱스로서 +1을 해줌.
					D[i][j] = Math.max(D[i][j], nCount); // 현재까지 온 칸의 수에다가 현재까지 온 칸의 수 VS 다음 칸으로 움직일 수 있는 칸의 수 중에 더 큰 수가 들어가게 된다.
					DFS( N, FOREST, D, nX, nY );
				}
			}
		}
		
		return D[i][j];
	}
}