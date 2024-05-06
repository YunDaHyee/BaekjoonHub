import java.io.*;

class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader	br			= new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter	bw			= new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int number = Integer.parseInt(br.readLine());
		int mutiple = 1;
		
		for(int i=2;i<=number;i++){
			mutiple*=i;
		}
		
		bw.write(String.valueOf(mutiple));
		bw.flush();
		bw.close();
		br.close();
	}

}