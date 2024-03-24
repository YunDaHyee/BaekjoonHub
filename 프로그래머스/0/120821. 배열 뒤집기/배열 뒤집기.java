class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        for( int i=0;i<num_list.length/2;i++ ){
            int temp = num_list[i];
            num_list[i] = num_list[length-i-1]; // 인덱스가 0에서부터 시작하니까 -1;
            num_list[length-i-1] = temp;
        }
        return num_list;
    }
}