import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	// x,y 좌표 - 좌우상하
	public static final int[] dx = {0,0,-1,1};
	public static final int[] dy = {-1,1,0,0};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int		cnt			= Integer.parseInt( br.readLine() );
		int[][] houseMatrix	= new int[cnt][cnt];	// 집 배열
		int[][] groupMatrix	= new int[cnt][cnt];	// 집에 해당되는 그룹번호(단지번호) 부여 배열
		int		groupN		= 0;					// 그룹번호

		// 값 초기화
		for( int i=0;i<cnt;i++ ) {
			String	line = br.readLine();
			for( int j=0;j<cnt;j++ ) { // 행
				int value = Integer.parseInt( String.valueOf(line.charAt(j)) );
				if( value!=0 ) {
					houseMatrix[i][j] = value;
				}
			}
		}
		
		// 그룹번호 묶기
		for( int i=0;i<cnt;i++ ){
			for( int j=0;j<cnt;j++ ){
				if( houseMatrix[i][j]==1 && groupMatrix[i][j]==0 ) { // 집 O , 방문 X
					BFS( houseMatrix, groupMatrix, i, j, ++groupN, cnt );
				}
			}
		}
		
		// 각 그룹번호별 집의 수 세기 
		int[] groupNArr = new int[groupN];
		for( int i=0;i<cnt;i++ ){
			for( int j=0;j<cnt;j++ ){
				if( groupMatrix[i][j]!=0 ){
					groupNArr[ groupMatrix[i][j]-1 ]++; // 단지가 1부터 시작되니까 인덱스를 위해 -1 해줘야함. 
				}
			}
		}
		
		Arrays.sort( groupNArr );						// 각 그룹번호 별 집의 수 정렬
		bw.write( String.valueOf(groupN+"\n") );		// 총 그룹번호 
		for ( int i=0; i<groupN; i++ ) {
			bw.write( String.valueOf(groupNArr[i])+"\n" );
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void BFS( int[][] matrix, int[][] group, int i, int j, int groupN, int size ) {
		Queue<COORDINATE> queue = new LinkedList<COORDINATE>(); // 방문한 집의 좌표를 담는 Queue

		// 값 초기화
		queue.add( new COORDINATE(i,j) );
		group[i][j] = groupN;
		
		// 주위에 집이 있/없 구분
		while( !queue.isEmpty() ){
			COORDINATE C = queue.remove();
			i = C.x;
			j = C.y;
			for( int k=0;k<4;k++ ){ // 방향은 4개에
				int realX = i+dx[k], realY = j+dy[k]; // 현재 방향에 맞춰서 주어진 좌표의 상하좌우를 탐색.
				if( realX >= 0 && realX < size && realY >= 0 && realY < size ){ // 매트릭스 사이즈 안에 있으면서
					if( matrix[realX][realY]==1 && group[realX][realY]==0 ){ // 집O, 방문X
						queue.add( new COORDINATE(realX, realY) );
						group[realX][realY] = groupN; // 해당 좌표에 해당 그룹번호 부여
					}
				}
			}
		}
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