class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        n = len(nums)
        pre = None

        while fast < n:
            if nums[fast] != pre:
                pre = nums[fast]
                nums[slow] = nums[fast]
                slow += 1
            fast += 1

        return slow
        