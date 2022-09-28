import java.io.*;
import java.util.Arrays;

class Main{
    static int max = 0;
	static int answer = 0;
	static int[] numbers = null;
	static boolean[] visit = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt( br.readLine() );
		String[] raws = br.readLine().split(" ");
		numbers = new int[N];
		visit	= new boolean[N];

		for( int i=0;i<raws.length;i++ ){
			numbers[i] = Integer.parseInt(raws[i]);
		}
		
		Arrays.sort(numbers); // 첫 순열을 만들기 위해서 정렬을 해줌
		
		DFS( 0,0,0 );
		
		System.out.println( answer );
		
		br.close();
	}
    
	private static void DFS(int count, int beforeNumber, int sum) {
		if( numbers.length==count ){
			answer = Math.max(answer, sum);
			return;
		}
		
		for( int i=0;i<numbers.length;i++ ){
			if( visit[i] ) {
				continue;
			}
			visit[i] = true;
			int temp = count==0 ? 0 : sum + Math.abs( beforeNumber-numbers[i] );
			DFS( count+1, numbers[i], temp ); 
			visit[i] = false;
		}
	}
    
}