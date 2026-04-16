class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = set()
        left = 0
        res = 0

        for i, char in enumerate(s):
            while char in window:
                window.remove(s[left])
                left += 1
            window.add(char)
            res = max(res, i- left + 1)
        
        return res


        