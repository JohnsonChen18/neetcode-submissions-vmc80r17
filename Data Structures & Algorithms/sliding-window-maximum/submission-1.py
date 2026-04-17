class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # init
        dq = deque()
        left = 0
        res = []
        for i in range(k-1):
            while dq and nums[dq[-1]] < nums[i]: dq.pop()
            dq.append(i)
        

        # body
        for right in range(k-1, len(nums)):
            # add right
            while dq and nums[dq[-1]] < nums[right]: dq.pop()
            dq.append(right)

            # get max
            while dq[0] < left:
                dq.popleft()
            res.append(nums[dq[0]])

            # update left
            left += 1
        
        return res