
class Solution {
    public double solution(int[] numbers) {
        // 1. 반복문이 아닌 방법으로 접근
        /*
            길이가 짝수일 때는 [(시작값+끝값)*길이절반]/길이
            홀수일 때는 중간값이 평균..
        */
        double answer = 0;
        int length = numbers.length;
        if( length%2!=0 ){
            answer = numbers[length/2];
        }else{
            answer = (double)(numbers[0]+numbers[length-1])*(length/2)/length;
        }
        return answer;

        // 2.  스트림 사용
        // return Arrays.stream(numbers).average().orElse(0);
    }
}
