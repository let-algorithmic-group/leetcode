# _*_ coding: utf-8 _*_


def findNthDigit(n: int) -> int:
    digit = 1
    while n > digit * 9 * (10 ** (digit - 1)):
        n -= digit * 9 * (10 ** (digit - 1))
        digit += 1
    a = int((n - 1) / digit)
    b = int((n - 1) % digit)
    num = 10 ** (digit - 1) + a
    res = list(str(num))[b]

    return int(res[0])


if __name__ == '__main__':
    print(findNthDigit(2891))
    print(findNthDigit(111))
    print(findNthDigit(1150))
    print(findNthDigit(1600))
    print(findNthDigit(168456321154512134154))
