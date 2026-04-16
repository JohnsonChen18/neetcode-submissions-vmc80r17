class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        window_len = len(s1)
        list1 = [0]*26
        list2 = [0]*26
        left = 0
        right = len(s1)-1

        for char in s1:
            list1[ord(char) - ord('a')] += 1

        for i in range(left, right + 1):
            list2[ord(s2[i]) - ord('a')] += 1
        
        while right < len(s2):
            if self.isEqual(list1, list2): return True
            list2[ord(s2[left]) - ord('a')] -= 1
            left += 1
            right += 1
            if right < len(s2): 
                list2[ord(s2[right]) - ord('a')] += 1
        
        return False
        

    def isEqual(self, list1, list2):
        for i in range(26):
            if list1[i] != list2[i]: return False
        return True
        