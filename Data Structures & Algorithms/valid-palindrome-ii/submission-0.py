class Solution:
    def validPalindrome(self, s: str) -> bool:
        n = len(s)
        return self._check(s, 0, n-1, 1)
    
    def _check(self, s:str, start:int, end:int, del_count:int) -> bool:
        if start >= end: return True

        left = start
        right = end

        while left <= right:
            # match
            if s[left] == s[right]:
                left += 1
                right -= 1
                continue

            # dosent match
            if del_count == 0: return False
            # try del left or right
            del_left_res = self._check(s, left+1, right, del_count-1)
            del_right_res = self._check(s, left, right-1, del_count-1)

            return del_left_res or del_right_res
        
        return True
            