class Solution {
    public int solution(int n, int t) {
        // 1.
        // return n * (int)Math.pow(2,t);
        
        // 2. 비트연산으로 한칸씩 밀면 2를 곱한거랑 같은거니까 t만큼 밀어주는 것
        return n << t;
    }
}
