package leetcode;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> ret = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str1 = new String(chars);
            List<String> same = new ArrayList<String>();
            if (!ret.containsKey(str1)) {
                ret.put(str1, new ArrayList<String>());
            }
            ret.get(str1).add(str);
        }
        return new ArrayList<List<String>>(ret.values());
    }
}
