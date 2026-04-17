class Solution:
    def minWindow(self, s: str, t: str) -> str:
        list1 = [0] * 58
        list2 = [0] * 58
        curr_match = 0
        match_goal = 0
        left = 0
        right = 0
        min_len = 2**31-1
        start = -1
        end = -1

        for char in t:
            list2[ord(char) - ord('A')] += 1

        while right < len(s):
            while right < len(s) and self.ifContains(list1, list2) == False:
                list1[ord(s[right]) - ord('A')] += 1
                right += 1
            while left < right and self.ifContains(list1, list2) == True:
                if (right - left) < min_len:
                    min_len = right - left
                    start = left
                    end = right
                list1[ord(s[left]) - ord('A')] -= 1
                left += 1
            # right += 1
        
        return s[start:end]
    
    def ifContains(self, list1, list2):
        for i in range(58):
            if list2[i] == 0: continue
            if list1[i] >= list2[i]:continue
            return False
        return True