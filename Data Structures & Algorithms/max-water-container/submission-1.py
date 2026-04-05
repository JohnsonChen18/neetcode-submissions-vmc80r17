class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        left = 0
        right = n - 1
        res = 0

        while left < right:
            curr_area = min(heights[left], heights[right]) * (right - left)
            res = max(res, curr_area)
            if heights[left] <= heights[right]:
                curr_num = heights[left]
                while left < right and heights[left] <= curr_num: left += 1
            else:
                curr_num = heights[right]
                while left < right and heights[right] <= curr_num: right -= 1
        
        return res
        