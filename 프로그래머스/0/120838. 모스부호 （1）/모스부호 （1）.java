import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        // 1.
        /*
        Map<String, String> morse = new HashMap<>();
        morse.put(".-","a");
        morse.put("-...","b");
        morse.put("-.-.","c");
        morse.put("-..","d");
        morse.put(".","e");
        morse.put("..-.","f");
        morse.put("--.","g");
        morse.put("....","h");
        morse.put("..","i");
        morse.put(".---","j");
        morse.put("-.-","k");
        morse.put(".-..","l");
        morse.put("--","m");
        morse.put("-.","n");
        morse.put("---","o");
        morse.put(".--.","p");
        morse.put("--.-","q");
        morse.put(".-.","r");
        morse.put("...","s");
        morse.put("-","t");
        morse.put("..-","u");
        morse.put("...-","v");
        morse.put(".--","w");
        morse.put("-..-","x");
        morse.put("-.--","y");
        morse.put("--..","z");

        StringBuilder answer = new StringBuilder();
        for( String each : letter.split(" ") ){
            answer.append( morse.get(each) );
        }
        
        return answer.toString();
        */
        
        // 2.
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] word = letter.split(" ");

        for(int i=0;i<word.length;i++){
            for(int j=0;j<morse.length;j++){
                if( word[i].equals(morse[j]) ){
                    answer+=(char)(j+97);
                }
            }
        }

        return answer;        
    }
}