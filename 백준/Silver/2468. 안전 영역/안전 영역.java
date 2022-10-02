import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main{	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map	= null;
	static int[][] group= null;
	static boolean[][] visit = null;
	
	static List<Integer> safeAreas = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0, max = 0, count = 0;
		int	N	= Integer.parseInt( br.readLine() ); // 크기
		map		= new int[N][N];
		group	= new int[N][N];
		visit	= new boolean[N][N];
		
		// 값 초기화
		for( int i=0;i<N;i++ ){
			String[] raws = br.readLine().split(" ");
			for( int j=0;j<N;j++ ){
				int value = Integer.parseInt(raws[j]);
				map[i][j] = value;
				max = Math.max(max, value); // 최대값 추출
			}
		}
		
		// 최대 높이까지 증가시키면서 안잠기는 지역이 많은 개수의 최대값 탐색
		for( int k=0;k<max;k++ ){
			count = 0;
			visit = new boolean[N][N];
			for( int i=0;i<N;i++ ){
				for( int j=0;j<N;j++ ){
					if( map[i][j]>k && !visit[i][j] ){ // 주어진 높이보다 높은 지역의 개수만 증가
						BFS( N, i, j, k );
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		
		System.out.println(answer);
	}
	
	private static void BFS(int N, int i, int j, int targetHeight ) {
		Queue<int[]>	queue = new LinkedList<>();
		
		visit[i][j] = true;
		queue.offer( new int[]{i,j} );
		
		while( !queue.isEmpty() ){
			int[]	current		= queue.poll();
			for( int k=0;k<4;k++ ){
				int adjacencyX = current[0] + dx[k], 
					adjacencyY = current[1] + dy[k];
				if( adjacencyX>-1&&adjacencyX<N&&adjacencyY>-1&&adjacencyY<N ){
					if( map[adjacencyX][adjacencyY]>targetHeight && !visit[adjacencyX][adjacencyY] ){
						visit[adjacencyX][adjacencyY] = true;
						queue.offer( new int[] {adjacencyX, adjacencyY} );
					}
				}
			}
		}
	}
    
}