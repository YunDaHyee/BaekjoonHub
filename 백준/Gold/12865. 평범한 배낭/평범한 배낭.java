import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] raws = br.readLine().split(" ");
		int	N = Integer.parseInt(raws[0]), // 물품의 수
			K = Integer.parseInt(raws[1]); // 버틸 수 있는 무게
		
		int[][] D = new int[N+1][K+1]; // DP 배열
		
		int[] W = new int[N+1]; // 무게
		int[] V = new int[N+1];	// 가치
		
		// 값 초기화
		/*for( int i=0;i<N;i++ ){
			raws = br.readLine().split(" ");
			items.add( new int[] { Integer.parseInt(raws[0]),Integer.parseInt(raws[1])} );
		}*/
		for( int i=1;i<=N;i++ ){
			raws = br.readLine().split(" ");
			W[i] = Integer.parseInt(raws[0]);
			V[i] = Integer.parseInt(raws[1]);
		}
		
		// 값 초기화는.. 어차피 0일 떈 0이라서 따로 필요하지 않음.
		
		for( int i=1;i<=N;i++ ){
			for( int j=1;j<=K;j++ ){
				D[i][j] = D[i-1][j]; // 이전 아이템의 가치를 저장함
				if( j - W[i]>=0 ){ // 무게에서 현재 무게를 뺐는데도 여유 무게가 있으면
					int beforeV = D[i-1][j]; // 이전 아이템에서 구한 가치
					int spareVplusCurrentV = D[i-1][j-W[i]]+V[i]; // 이전 무게에 대한 k-현재 무게한 가치 + 현재 가치
					D[i][j] = Math.max( beforeV, spareVplusCurrentV );
				}
			}
		}
		
		System.out.println( D[N][K] );
	}
}