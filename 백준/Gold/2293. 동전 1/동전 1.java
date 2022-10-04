import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] raws = br.readLine().split(" ");
		int	N = Integer.parseInt(raws[0]), // 동전의 가지수
			K = Integer.parseInt(raws[1]); // 동전의 목표 합
		
		int[] coin = new int[N+1];	// 사용할 수 있는 동전의 종류를 담는 배열
		int[] memo = new int[K+1];	/* 동전을 사용해서 합이 각 index원이 되도록 하는 경우의 수.
                                       즉, 각 인덱스 == 목표합,  각 값 == 그 목표합이 되는 경우의 수
                                     */
		
		// 값 초기화
		for( int i=1;i<=N;i++ ){
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		// 초기값 설정
		memo[0] = 1; // 합이 0원을 나타낼 수 있는 경우의 수는 아무것도 넣지 않아도 바로 가능하니까 1가지가 존재하는 것
		for( int i=1;i<=N;i++ ) {
			int currentCoinCount = coin[i]; // 사용할 수 있는 동전의 수
			//System.out.println( "사용할 수 있는 동전의 수 = " + currentCoinCount);
			for( int j=currentCoinCount;j<=K;j++ ){
				memo[j] = memo[j] + memo[j-currentCoinCount]; // 2
				//System.out.println( "동전 "+ currentCoinCount +"개를 사용해서 합이 "+(j-currentCoinCount)+"원이 되도록 하는 경우의 수 : "+memo[j]);
			}
		}
		
		System.out.println(memo[K]);
		br.close();
	}
}