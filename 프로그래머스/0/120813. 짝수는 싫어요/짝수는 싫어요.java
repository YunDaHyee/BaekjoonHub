import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        // 1. 단순
        //int[] answer = new int[n/2+n%2];
        //for( int i=1;i<=n;i++ ){
        //    if( i%2==0 ) {
        //        continue;
        //    }
        //    answer[i/2]=i;
        //}
        
        // return answer;
        
        // 2. stream
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}