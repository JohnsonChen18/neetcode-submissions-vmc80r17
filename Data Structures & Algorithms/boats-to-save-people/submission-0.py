class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        sorted_people = sorted(people)
        res = 0
        n = len(people)
        left = 0
        right = n - 1

        while left <= right:
            sum = sorted_people[left] + sorted_people[right]
            if left == right or sum > limit:
                res += 1
                right -= 1
            else:
                res += 1
                left += 1
                right -= 1
        return res