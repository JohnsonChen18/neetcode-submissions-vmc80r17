class Solution:
    def trap(self, heights: List[int]) -> int:
        left_max = 0
        right_max = 0
        left = 0
        n = len(heights)
        right = n - 1
        res = 0

        while left <= right:
            if left_max <= right_max:
                if left_max - heights[left] > 0: res += left_max - heights[left]
                left_max = max(left_max, heights[left])
                left += 1
            else:
                if right_max - heights[right] > 0 : res += right_max - heights[right]
                right_max = max(right_max, heights[right])
                right -= 1

        return res

        