class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # num:last index
        map = dict()

        for i, num in enumerate(nums):
            if num in map and abs(i - map[num]) <= k: return True
            map[num] = i
        
        return False


        