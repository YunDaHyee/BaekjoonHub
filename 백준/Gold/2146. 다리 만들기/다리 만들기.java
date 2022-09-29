import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{
	static int[]		dx		= {-1,1,0,0}, dy = {0,0,1,-1};
	static int[][]		map		= null;
	static int[][]		group	= null;
	static int[][]		distance= null;
	static Queue<int[]>	extension= new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));
		int				N	= Integer.parseInt(br.readLine());
		
		map		= new int[N][N];
		group	= new int[N][N];
		distance= new int[N][N];
		
		/*
		 *  지도 초기화
		 */
		for( int i=0;i<N;i++ ){
			String[] raws = br.readLine().split(" ");
			for( int j=0;j<N;j++ ){
				int value = Integer.parseInt(raws[j]);
				if( value==0 ) {
					distance[i][j] = -1; // 거리 배열에서 확장될 영역임을 표시
					continue;
				}
				map[i][j] = value;
				extension.offer( new int[] {i, j} );  // 확장에 필요한 좌표값만 담음
			}
		}
		
		/* 
		 * 그룹번호 지정
		 */
		int groupNumber = 0;
		for( int i=0;i<N;i++ ){
			for( int j=0;j<N;j++ ){
				if( map[i][j]==1 && group[i][j]==0 ){
					setGroupNumber( N, i, j, ++groupNumber );
				}
			}
		}
		
		/*
		 *  그룹번호 간의 차이를 알기 위한 거리 확장
		 */
		setMinDistance( N );
				
		/*
		 * 다리 선택
		 * 각 칸의 인접한 곳과 그룹번호가 다르면 다리를 만들 수 있으므로 해당 거리들을 합산해서 작은 수를 고름
		 */
		int answer = Integer.MAX_VALUE;
		for( int i=0;i<N;i++ ){
			for( int j=0;j<N;j++ ){
				for( int k=0;k<4;k++ ){
					int	adjacencyX	= i+dx[k],
						adjacencyY	= j+dy[k];
					if( adjacencyX>-1&&adjacencyX<N&&adjacencyY>-1&&adjacencyY<N ){
						if( group[i][j]!=group[adjacencyX][adjacencyY] ){
							answer = Math.min( answer, distance[i][j]+distance[adjacencyX][adjacencyY] );
						}
					}
				}
			}
		}
		
		System.out.println( answer );
		
		br.close();
	}
	
	private static void setMinDistance(int N) {
		while( !extension.isEmpty() ){
			int[]	current		= extension.poll();
			int		currentX	= current[0],
					currentY	= current[1];
			for( int i=0;i<4;i++ ){
				int adjacencyX = currentX + dx[i],
					adjacencyY = currentY + dy[i];
				if( adjacencyX>-1&&adjacencyX<N&&adjacencyY>-1&&adjacencyY<N ){
					// 현재 위치에서 인접하고 확장될 영역일 때만 현재 위치의 그룹번호를 넣어줌으로써 그룹을 확장시킴
					if( distance[adjacencyX][adjacencyY]==-1 ){ 
						extension.offer(new int[] {adjacencyX, adjacencyY});
						group[adjacencyX][adjacencyY] = group[currentX][currentY];
						distance[adjacencyX][adjacencyY] = distance[currentX][currentY]+1;
					}
				}
			}
		}
	}

	private static void setGroupNumber(int N, int i, int j, int groupNumber ) {
		Queue<int[]>	queue		= new LinkedList<>();
		
		group[i][j] = groupNumber;
		queue.offer( new int[]{i,j} );
		
		while( !queue.isEmpty() ){
			int[]	current		= queue.poll();
			int		currentX	= current[0],
					currentY	= current[1];
			distance[currentX][currentY] = 0; // 거리 배열에서 시작될 영역임을 표시
			
			for( int k=0;k<4;k++ ){
				int adjacencyX = currentX + dx[k],
					adjacencyY = currentY + dy[k];
				if( adjacencyX>-1&&adjacencyX<N&&adjacencyY>-1&&adjacencyY<N ){
					if( map[adjacencyX][adjacencyY]==1 && group[adjacencyX][adjacencyY]==0 ){
						distance[adjacencyX][adjacencyY] = 0;
						group[adjacencyX][adjacencyY] = groupNumber;
						queue.offer( new int[] {adjacencyX, adjacencyY} );
					}
				}
			}
		}
	}

}