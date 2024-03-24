class Solution {
    public int[] solution(int money) {
        // 1.
        int count = money/5500;
        int remain = 5500*count;
        return new int[]{count, money-remain};

        // 2.
        // return new int[] { money / 5500, money % 5500 };
    }
}
