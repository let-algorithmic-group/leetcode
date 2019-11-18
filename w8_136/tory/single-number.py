class HashObject:
    def __init__(self, number):
        self.number = number


class Solution:
    def singleNumber(self, nums) -> int:
        max_number = max(nums)
        a_list = [0 for i in range(max_number + 1)]
        b_list = [0 for i in range(max_number + 1)]
        for i in nums:
            if i in b_list:
                temp = b_list[i]
                b_list[i] = temp + 1
            else:
                b_list[i] = 1
            a_list[i] = i
        print(a_list)
        print(b_list)
        for i in range(len(b_list)):
            if b_list[i] == 1:
                return a_list[i]

    def getHash(self, hashObject: HashObject, listSize):
        h = hash(hashObject)
        hs = h ^ (h > 16)
        return (listSize - 1) & hs


if __name__ == "__main__":
    s = Solution()
    print(s.singleNumber([1]))
    print(s.getHash(HashObject(-3),5))
