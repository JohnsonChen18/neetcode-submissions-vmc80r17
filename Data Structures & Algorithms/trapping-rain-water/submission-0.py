class Solution:
    # currAre = min(firt bigger in left, first bigger in right) - currHeight
    def trap(self, heights: List[int]) -> int:
        n = len(heights)
        left_max = [0] * n
        right_max = [0] * n

        # build left max
        curr_max = 0
        for i in range(n):
            left_max[i] = curr_max
            curr_max = max(curr_max, heights[i])

        # build right max
        curr_max = 0
        for i in range(n-1,-1,-1):
            right_max[i] = curr_max
            curr_max = max(curr_max, heights[i])

        res = 0

        for i in range(n):
            curr_area = min(left_max[i], right_max[i]) - heights[i]
            if curr_area > 0 : res += curr_area

        return res
            