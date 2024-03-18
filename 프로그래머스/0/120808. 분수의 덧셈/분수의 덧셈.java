class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분자 numer, 분모 denom
        int newNumer1,newNumer2,common,sumNumer;

        newNumer1 = numer1*denom2;
        newNumer2 = numer2*denom1;
        common = denom1*denom2;

        sumNumer = newNumer1 + newNumer2;

        int max = 1; // 1은 모든 자연수의 공약수
        
        for( int i=1;i<=sumNumer&&i<=common;i++ ){
            if( sumNumer%i==0&&common%i==0 ) {
                max = i;
            }
        }

        int[] answer = { sumNumer/max, common/max }; // 최대공약수로 나눈 값
            
        return answer;
    }
}