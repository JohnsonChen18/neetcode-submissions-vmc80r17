class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        len1 = len(word1)
        len2 = len(word2)
        p1 = 0
        p2 = 0
        res = []


        while p1 < len1 and p2 < len2:
            res.append(word1[p1])
            p1 += 1
            res.append(word2[p2])
            p2 += 1

        
        res.extend(word1[p1:])
        res.extend(word2[p2:])

        return "".join(res)
        

