import java.util.stream.IntStream;
class Solution {
    public int solution(int n) {
        // 1.
        //return IntStream.rangeClosed(1,n).filter(i->i%2==0).sum();
        
        // 2.
        int answer = 0;
        for( int i=2;i<=n;i+=2 ){
            answer += i;
        }
        return answer;
    }
}