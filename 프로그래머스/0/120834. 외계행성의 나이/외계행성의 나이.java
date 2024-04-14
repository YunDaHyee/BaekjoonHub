class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        
       // 1.
       /*
       char[] cs = new char[10];
       char c='a';
       for( int i=0;i<10;i++ ){
           cs[i]=c++;
       }
       String[] parsedAges = String.valueOf(age).split("");
       for( String parsedAge : parsedAges ){
           answer.append( cs[Integer.parseInt(parsedAge)] );
       }
       */

        // 2.
        while(age>0){
            answer.insert( 0, (char)(age%10+(int)'a') );// int형으로 아스키값에 대한 10진수를 구함
            age/=10;
        }
        
        return answer.toString();
    }
}
