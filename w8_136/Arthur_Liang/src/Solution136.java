package com.arthur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }

        return a;
    }

    public int singleNumber1(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer num : nums) {
            if (list.contains(num)) {
                list.remove(num);
                continue;
            }
            list.add(num);
        }
        return list.get(0);
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            int value = 1;
            if (hashMap.containsKey(num)) {
                value += hashMap.get(num);
            }
            hashMap.put(num, value);
        }

        int retIndex = Integer.MAX_VALUE;
        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) {
                retIndex = i;
                break;
            }
        }

        return retIndex;
    }
}
