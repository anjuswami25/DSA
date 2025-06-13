class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, sMax = Long.MIN_VALUE, tMax = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                tMax = sMax;
                sMax = max;
                max = num;
            } else if (num > sMax) {
                if (num != max) {
                    tMax = sMax;
                    sMax = num;
                }
            } else if (num > tMax && sMax != num) {
                tMax = num;
            }
        }
        return tMax == Long.MIN_VALUE ? (int) max : (int) tMax;
    }
}