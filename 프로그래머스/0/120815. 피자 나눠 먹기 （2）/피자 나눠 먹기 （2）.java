class Solution {
    public int solution(int n) {
        // 6조각 잘라줌. 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지.
        int answer = 1;
        int remaining = 6;
        while (remaining % n != 0) {
            answer +=1;
            remaining += 6;
            
        }
        return answer;
    }
}       