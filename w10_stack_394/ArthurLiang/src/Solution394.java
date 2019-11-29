package leetcode;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode-cn.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (46.85%)
 * Likes:    154
 * Dislikes: 0
 * Total Accepted:    11.3K
 * Total Submissions: 24.2K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 *
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
public class Solution394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<String> stack_res = new LinkedList<String>();
        Deque<Integer> stack_multi = new LinkedList<Integer>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();

            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int currentMulti = stack_multi.pop();
                for (int i = 0; i < currentMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp.toString());

            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
// @lc code=end

