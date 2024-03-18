class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분자 numer, 분모 denom
        int[] answer = new int[2];
        int newNumer1,newNumer2,common,sumNumer;

        newNumer1 = denom1==denom2?numer1:numer1*denom2;
        newNumer2 = denom1==denom2?numer2:numer2*denom1;
        common = denom1==denom2?denom1:denom1*denom2;

        sumNumer = newNumer1 + newNumer2;

        while( sumNumer%2==0&&common%2==0 ){
            sumNumer/=2;
            common/=2;
        }

        answer[0] = sumNumer;
        answer[1] = common;
            
        return answer;
    }
}