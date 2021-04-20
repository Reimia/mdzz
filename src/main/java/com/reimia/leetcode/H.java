package com.reimia.leetcode;

import java.util.Arrays;

public class H {
    public static void main(String[] args) {
////        System.out.println(Arrays.toString(runningSum(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})));
//        LRUCache obj = new LRUCache(3);
//        int param_1 = obj.get(1);
//        obj.put(1,1);
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }
}
