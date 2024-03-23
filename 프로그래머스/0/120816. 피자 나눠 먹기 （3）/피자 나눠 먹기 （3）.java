class Solution {
    public int solution(int slice, int n) {
        double answer = 0.0;
        while ((slice * answer) / n < 1.0) {
            answer +=1;
        }
        return (int)answer;
    }
}