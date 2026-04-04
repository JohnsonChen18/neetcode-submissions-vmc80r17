class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []

        nums.sort(key=lambda x:(x))

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]: continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                curr_sum = nums[i] + nums[left] + nums[right]
                if curr_sum == 0:
                    res.append([nums[i], nums[left], nums[right]])
                    curr_left = nums[left]
                    while left < right and nums[left] == curr_left: left += 1
                    curr_right = nums[right]
                    while left < right and nums[right] == curr_right: right -= 1
                elif curr_sum < 0:
                    curr_left = nums[left]
                    while left < right and nums[left] == curr_left: left += 1
                else:
                    curr_right = nums[right]
                    while left < right and nums[right] == curr_right: right -= 1

        return res