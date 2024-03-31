import java.util.Arrays;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        Arrays.sort(array);
        int middle = (array.length-1)/2;
        int start = array[middle]<height ? middle+1 : 0;
        
        for( int i=start;i<array.length;i++ ){
            if( height<array[i] ){
                answer++;
            }
        }     
       
        return answer;
    }
}