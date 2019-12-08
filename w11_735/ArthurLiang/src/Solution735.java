package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int ast : asteroids) {
            // 栈为空或者 符号相同 或者 方向相反 直接入栈
            // 相乘大于0表示符号相同；栈顶小于0 变量大于0说明方向不一致不相关
            if (stack.isEmpty() || ast * stack.peek() > 0 || (stack.peek() < 0 && ast > 0)) {
                stack.push(ast);
            } else {
                boolean flag = true;
                // 符号不同相乘小于0
                while (!stack.isEmpty() && stack.peek() * ast < 0) {
                    if (Math.abs(stack.peek()) == Math.abs(ast)) {
                        stack.pop();
                        flag = false;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(ast)) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    stack.push(ast);
                }
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        int index = size - 1;
        while (stack.size() > 0) {
            res[index--] = stack.pop();
        }

        return res;
    }
}
