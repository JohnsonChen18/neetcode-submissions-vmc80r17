class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_count = [0]*26
        max_count = 0
        left = 0
        res = 0

        for i, char in enumerate(s):
            char_count[ord(char) - ord('A')] += 1
            max_count = self._getMax(char_count)

            while (i - left + 1) - max_count > k:
                char_count[ord(s[left]) - ord('A')] -= 1
                left += 1
                max_count = self._getMax(char_count)
            res = max(res, i - left + 1)

        return res


    
    def _getMax(self, char_count):
        res = 0
        for count in char_count:
            res = max(res, count)

        return res