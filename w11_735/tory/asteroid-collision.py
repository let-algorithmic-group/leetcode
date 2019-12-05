class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        result = []
        for a in asteroids:
            while result and a < 0 < result[-1]:
                if result[-1] < -a:
                    result.pop()
                    continue
                elif result[-1] == -a:
                    result.pop()
                break
            else:
                result.append(a)
        return result
