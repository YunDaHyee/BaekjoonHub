class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        char[] cs = new char[10];
        char c='a';
        for( int i=0;i<10;i++ ){
            cs[i]=c++;
        }
        String[] parsedAges = String.valueOf(age).split("");
        for( String parsedAge : parsedAges ){
            answer.append( cs[Integer.parseInt(parsedAge)] );
        }
        return answer.toString();
    }
}