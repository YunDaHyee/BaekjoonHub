class Solution {
    public int[] solution(int money) {
        int count = money/5500;
        int remain = 5500*count;
        return new int[]{count, money-remain};
    }
}