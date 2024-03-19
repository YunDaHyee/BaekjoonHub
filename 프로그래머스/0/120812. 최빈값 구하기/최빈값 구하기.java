import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {        
        Arrays.sort(array);
        Map<Integer, Integer> keyset = new HashMap<>();
        for( int target : array ){
            if( keyset.containsKey(target) ){
                keyset.put( target, keyset.get(target)+1 );
                continue;
            }
            keyset.put(target, 1);
        }

        int maxCount = -1;
        int frequentNumber = 0; // 유일해야 하는 최고 빈번 수..
        int beforeFrequentNumber = -1; // 만약 동일한 개수로 있다면 유일 빈번수랑 같이 담기게될 변수.
                                        /*
                                        - 0으로 값을 초기화 하면 안되는 이유
                                            테케 {0} 가 주어지면 0일 때에 대한 횟수를 조회해야하는데
                                            원소가 하나밖에 없는데도 0으로 이미 초기화 되어있는 바람에
                                            존재하지도 않았던 것이 이미 들어가있는 것처럼 비교해서 "같으니 -1이야" 라고 뱉을 수 있기 때문
                                        */

        for( int key : keyset.keySet() ){
            int targetCount = keyset.get(key);
            if( maxCount < targetCount ){
                maxCount = targetCount;
                frequentNumber = key;
            }else if( maxCount==targetCount ){
                beforeFrequentNumber = key;
            }
        }

        int result = frequentNumber;
        /*
            처음에는 겹치는 횟수를 카운트 하고
            `겹침 수 == 담긴 숫자 길이(1,3,7가 들었다면 3)` 이라면
            유일 빈번수는 없다고 판단해주기 위해서 겹치는 횟수를 카운트해줌.
            하지만 유일 빈번수랑 동일한 빈번수가 하나라도 있다면 겹치는 것이기 땜에 겹치는 횟수를 굳이 샐 필요가 없음!
        */
        if( keyset.get(frequentNumber)==keyset.get(beforeFrequentNumber) ){
            result = -1;
        }
        
        return result;
    }
}