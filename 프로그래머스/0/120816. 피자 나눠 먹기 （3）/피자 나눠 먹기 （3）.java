class Solution {
    public int solution(int slice, int n) {
        // 1.
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

        // 2.
        /*
            사람수 (n) % 피자조각 (slice)의 나머지 > 0 => 피자를 한 판 더 시켜야 모두 한 조각 이상 먹을 수 있습니다.
            => answer = 사람수 (n) / 피자조각 (slice) +1(피자 한 판)
            return n % slice > 0 ? n/slice+1 : n/slice;
        */
    }
}
