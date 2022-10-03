import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
        System.out.println( BottomUp(N) );
    }
    
    public static int BottomUp(int N) {
		memo[1] = 0;  // 연산을 사용하지 않고도 N 자체가 1이면 연산 안해도 구해지는 거니까
		
		for( int i=2;i<=N;i++ ) { // 0,1을 제외하고 가장 작은 조건인 2에서부터 차례대로 푼다.
			memo[i] = memo[i-1]+1;
			if( i%2==0 ) {
				memo[i] = Math.min(memo[i], memo[i/2]+1 );
			}
			if( i%3==0 ) {
				memo[i] = Math.min(memo[i], memo[i/3]+1 );
			}
		}
		
		return memo[N];
	}
    
}