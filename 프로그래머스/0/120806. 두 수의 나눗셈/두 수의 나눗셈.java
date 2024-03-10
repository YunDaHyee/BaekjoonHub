
class Solution {
    public double solution(int num1, int num2) {
        double division = (double)num1/(double)num2;
        return Math.floor(division*1000);
    }
}