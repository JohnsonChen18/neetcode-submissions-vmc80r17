class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        resP = n + m - 1
        p1 = m - 1
        p2 = n - 1

        while p2 >= 0:
            if p1 < 0 or nums2[p2] >= nums1[p1]:
                nums1[resP] = nums2[p2]
                p2 -= 1
            else:
                nums1[resP] = nums1[p1]
                p1 -= 1
            resP -= 1;

        return