import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] info = br.readLine().split(" ");
		int siteCount = Integer.parseInt(info[0]), targetCount = Integer.parseInt(info[1]);
		Map<String, String> memos = new HashMap<String, String>();
		StringBuffer result = new StringBuffer();
		for( int i=0;i<siteCount;i++ ) {
			String[] raws = br.readLine().split(" ");
			memos.put( raws[0], raws[1] );
		}
		
		for( int i=0;i<targetCount;i++ ) {
			String raws = br.readLine();
			result.append( memos.get(raws) );
			if( i!=targetCount-1 ) {
				result.append("\n");
			}
		}
		bw.write( result.toString() );
		bw.flush();
		bw.close();
	}
}