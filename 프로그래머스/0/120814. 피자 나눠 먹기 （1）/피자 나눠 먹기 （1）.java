class Solution {
    public int solution(int n) {
        int pizza = n/7;
        int spare = n%7;

        if( spare!=0 ){
            pizza++;
            for( ;spare>7;spare%=7 ){
                pizza++;
            }
        }
        
        return pizza;
    }
}