import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        // 1.
        /*
        int length = num_list.length;
        for( int i=0;i<num_list.length/2;i++ ){
            int temp = num_list[i];
            num_list[i] = num_list[length-i-1]; // 인덱스가 0에서부터 시작하니까 -1;
            num_list[length-i-1] = temp;
        }
        return num_list;
        */
        
        // 2.
        // num_list랑 똑같은 길이를 가지는int 스트림 만들고 num_list의 뒤에 값부터 출력해서 Array로 리턴
        return IntStream
                    .range(1, num_list.length+1)
                    .map(i -> num_list[num_list.length-i])
                    .toArray();
    }
}