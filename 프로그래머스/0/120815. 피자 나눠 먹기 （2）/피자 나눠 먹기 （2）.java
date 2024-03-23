class Solution {
    public int solution(int n) {
        // 6조각 잘라줌. 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지.
        
        // GCD
        int a = n;
        int b = 6;
        while( b!=0 ){
            int r = a%b;
            a = b;
            b = r;
        }

        int LCD  = (n*6)/a;
        
        return LCD/6;
    }
}
