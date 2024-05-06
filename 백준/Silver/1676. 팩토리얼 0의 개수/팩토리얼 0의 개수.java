import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		
		int N			= Integer.parseInt(br.readLine());
		int zeroCount	= 0;
		
		while( N>=5 ){
			zeroCount+=(N/=5);
		}
		
		System.out.println(zeroCount);
		
		br.close();
    }
}