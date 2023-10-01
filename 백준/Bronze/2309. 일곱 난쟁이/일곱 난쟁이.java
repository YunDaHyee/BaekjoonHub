import java.io.*;
import java.util.Arrays;

class Main{
    static int sum = 0;
	static int[] dwarfs = new int[9];

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for( int i=0;i<9;i++ ){
			int height = Integer.parseInt(br.readLine());
			dwarfs[i] = height;
			sum+=height; // sum = 140
		}
		
		Arrays.sort(dwarfs);
        
        go(0,0); // 3. 오로지 재귀 호출로만
		
		br.close();
	}

	public static void go(int first, int second) {
		if( second==9 ){
			first++;
			second=0;
		}
		
		if( sum - dwarfs[first] - dwarfs[second] == 100 ){
			for( int i=0;i<9;i++ ){
				if( first==i||second==i ){
					continue;
				}
				System.out.println(dwarfs[i]);
			}
			System.exit(0);
		}else{
			go(first,++second);
		}
    }
}