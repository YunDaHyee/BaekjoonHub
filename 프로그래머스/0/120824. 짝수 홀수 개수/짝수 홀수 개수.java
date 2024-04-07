import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        // 1.
        // return new int[]{
        //         (int) Arrays.stream(num_list).filter(i->i%2==0).count()
        //     , (int) Arrays.stream(num_list).filter(i->i%2!=0).count()
        // };
        
        int evenCount = 0;
        int oddCount = 0;
        
        for( int i=0;i<num_list.length;i++ ){
            if( num_list[i]%2==0 ) evenCount++;
            else oddCount++;
            
        }
        return new int[]{evenCount, oddCount};
    }
}