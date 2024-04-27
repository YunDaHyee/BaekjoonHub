import java.util.HashMap;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        HashMap<Integer, Integer> orderedPair = new HashMap<>();
        int sqrt = (int) Math.sqrt(n);
        int duplicationNumberCount = 0;
        
        for( int i=1;i<=sqrt;i++ ){
            if( n%i==0 ){
                orderedPair.put( i,0 );
            }
        }
        
        for( int key : orderedPair.keySet() ){
            int pairDivisor = n/key;
            if( key != pairDivisor ){
                orderedPair.put( key,pairDivisor );
            }else{
                duplicationNumberCount++;
            }
        }
        
        return orderedPair.size()*2-duplicationNumberCount;

        // 2.
        /*
            if(n < 2)
                return n;
            int answer = 2; // 1과 자기자신
            for(int i=2; i<Math.sqrt(n+1); i++){
                if(n % i == 0){
                    answer += i == n / i ? 1 : 2;
                }
            }
            return answer;
        */

        // 3. O(n)이지만 스트림 이용
        // return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
}