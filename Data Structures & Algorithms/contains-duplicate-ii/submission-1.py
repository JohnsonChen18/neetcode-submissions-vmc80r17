class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # num:last index
        num_set = set()

        for i, num in enumerate(nums):
            if num in num_set: return True
            num_set.add(num)

            if len(num_set) > k:
                num_set.remove(nums[i-k])
        
        return False


        