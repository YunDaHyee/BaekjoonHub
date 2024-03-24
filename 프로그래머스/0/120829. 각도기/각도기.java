class Solution {
    public int solution(int angle) {
        if( angle==180 ){ // 평각
            return 4;
        }
        
        if( angle==90 ){ // 직각
            return 2;
        }
        
        if( angle<90 ){ // 예각
            return 1;
        }
        
        return 3;
    }
}