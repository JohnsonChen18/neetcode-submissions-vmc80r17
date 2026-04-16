class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = set()
        left = 0
        res = 0

        for i in range(len(s)):
            while s[i] in window:
                window.remove(s[left])
                left += 1
            window.add(s[i])
            res = max(res, i- left + 1)
        
        return res


        