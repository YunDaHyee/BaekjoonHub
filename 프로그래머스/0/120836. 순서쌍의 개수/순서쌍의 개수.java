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
    }
}