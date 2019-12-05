class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        res = ''
        num = 0
        for c in s:
            if c == '[':
                stack.append([num, res])
                res = ''
                num = 0
            elif c == ']':
                temNum, temStr = stack.pop()
                res = temStr + temNum * res
            elif '0' <= c <= '9':
                num = num * 10 + int(c)
            else:
                res += c
        return res