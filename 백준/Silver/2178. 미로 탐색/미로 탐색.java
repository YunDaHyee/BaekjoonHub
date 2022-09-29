import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    private static int[] dx = {-1,1,0,0}, dy = {0,0,1,-1}; // 좌우상하
	private static int[][] mazeMatrix; 
	private static boolean[][] flagMatrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
	
		String[]		raw			= br.readLine().split(" ");
		int				N			= Integer.parseInt( raw[0] ), M = Integer.parseInt( raw[1] );
		
        mazeMatrix	= new int[N][M];	// 미로 매트릭스 - 세로,가로
		flagMatrix	= new boolean[N][M];// 방문여부 매트릭스 - 세로,가로
		
		// 값 초기화
		for( int i=0;i<N;i++ ){
			String num = br.readLine();
			for( int j=0;j<M;j++ ){
				if( Integer.parseInt(String.valueOf(num.charAt(j)))!=0 ){
					mazeMatrix[i][j] = 1;
				}
			}
		}
		
		bw.write( String.valueOf(BFS(N, M)) );
        
        br.close();
		bw.flush();
		bw.close();
	}
	
	public static int BFS( int N, int M ){
		Queue<COORDINATE>	queue			= new LinkedList<COORDINATE>();
		int[][]				incrementMatrix = new int[N][M];
        
        // 값 초기화
		flagMatrix[0][0]		= true;
		incrementMatrix[0][0]	= 1;
		queue.add( new COORDINATE(0, 0) );
		
        // 4방위 중 최단거리 구하기
		while( !queue.isEmpty() ){
			COORDINATE c = queue.remove();
			int i = c.x;
			int j = c.y;for( int k=0;k<4;k++ ){
				int realX = i+dx[k], realY =j+dy[k];
				if( realX>=0 && realX<N && realY>=0 && realY<M ){
					if( mazeMatrix[realX][realY]==1 && flagMatrix[realX][realY]==false ){
						flagMatrix[realX][realY] = true;
						queue.add( new COORDINATE(realX, realY) );
						incrementMatrix[realX][realY] = incrementMatrix[i][j]+1; // 4방위의 중심축(주인공)의 거리수에서 +1을 해줌
					}
				}
			}
		}
		return incrementMatrix[N-1][M-1]; // 0부터 시작하니까 인덱스=사이즈-1 해줘야함.
	}
}

// 방문한 집의 좌표
class COORDINATE{
	int x, y;
	
	COORDINATE(int x, int y){
		this.x = x;
		this.y = y;
	}
}