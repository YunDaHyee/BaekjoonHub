import java.io.*;

class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
	
		String[] raws = br.readLine().split(" ");
		int zeroCountBy2 = getZeroCountBy2( Integer.parseInt(raws[0]) );
		int zeroCountBy5 = getZeroCountBy5( Integer.parseInt(raws[0]) );
		
		for( int i=0;i<2;i++ ){
			int value = Integer.parseInt(raws[i]);
			if( i==0 ){
				value = Integer.parseInt(raws[0])-Integer.parseInt(raws[1]);
			}
			zeroCountBy2-=getZeroCountBy2(value);
			zeroCountBy5-=getZeroCountBy5(value);
		}
		
		System.out.println(Math.min(zeroCountBy2, zeroCountBy5));
		
		br.close();
	}
	
	public static int getZeroCountBy2(int number) {
		int result = 0;
		while( number>=2 ){
			result += (number/=2);
		}
		return result;
	}
	
	public static int getZeroCountBy5(int number) {
		int result = 0;
		while( number>=5 ){
			result += (number/=5);
		}
		return result;
	}
}