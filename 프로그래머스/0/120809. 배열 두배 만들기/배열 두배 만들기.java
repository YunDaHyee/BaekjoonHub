
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        // 1. 단순 반복문
        // int     numberSize  = numbers.length;
        // int[]   answer      = new int[numberSize];
        
        // for( int i=0;i<numberSize;i++ ){
            // answer[i] = numbers[i]*2;
        // }
        
        // return answer;
        
        // 2. stream 이용
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
        
    }
}