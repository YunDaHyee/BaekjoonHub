class Solution {
    public int solution(int n) {
        // 1.
        // int pizza = n/7;
        // int spare = n%7;

        // if( spare!=0 ){
        //     pizza++;
        //     for( ;spare>7;spare%=7 ){
        //         pizza++;
        //     }
        // }

        //return pizza;
        
        // 2.
        // return (n + 6) / 7;
        // 6 == 어떤 수를 7로 나눴을 때 0부터 나올 수 있는 나머지의 한계
        
        // 3.
        // return n%7==0 ? n/7 : (n/7)+1;
    }
}
