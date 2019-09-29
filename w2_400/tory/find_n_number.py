class Solution:
    def findNthDigit(self, n: int) -> int:
        if n < 10:
            return n
        i, resNMax = 0, 0
        while resNMax < n:
            i += 1
            resNMax = resNMax + 9 * pow(10, i - 1) * i
        num = n - (resNMax - 9 * pow(10, i - 1) * i)
        temp = num // i
        if num % i == 0:
            temp = temp - 1
        res = temp + pow(10, i - 1)
        return int(str(res)[num % i - 1])
