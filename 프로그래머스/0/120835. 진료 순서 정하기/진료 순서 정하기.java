import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> es = new HashMap<Integer,Integer>();
        int length = emergency.length;
        int[] copy = emergency.clone();
        int[] answer = new int[length];
        
        Arrays.sort(copy);
        
        int rank = length;
        
        while( rank>0 ){
            es.put(copy[rank-1],1+length-(rank--));
        }

        while( rank<length ){
            answer[rank] = es.get(emergency[rank++]);
        }
        
        return answer;
    }
}