class Solution {
    public int solution(int slice, int n) {
        int answer = n/slice;
        int nmg = n%slice;
        while( nmg!=0 ){
            answer++;
            if( nmg<slice ){
                break;
            }
            nmg%=slice;
        }
        return answer;
    }
}