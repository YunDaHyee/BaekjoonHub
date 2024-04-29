class Solution {
    public String solution(String rsp) {
        // 가 2, 바위 0, 보 5
        StringBuilder answer = new StringBuilder();

        for( String each : rsp.split("") ) {
            switch (each) {
                case "2" -> answer.append("0");
                case "0" -> answer.append("5");
                default -> answer.append("2");
            }
        }
        
        return answer.toString();
    }
}