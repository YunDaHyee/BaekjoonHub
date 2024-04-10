import java.util.Arrays;
import java.util.stream.Collectors;
    
class Solution {
    public String solution(String my_string, String letter) {
        // 1.
        // return Arrays.stream(my_string.split("")).filter(i->!i.equals(letter)).collect(Collectors.joining());
        
        // 2.
        return my_string.replace(letter, "");
    }
}
