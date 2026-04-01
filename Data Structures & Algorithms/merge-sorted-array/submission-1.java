class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resP = n + m - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while(resP >= 0){
            if(p1 < 0 || (p2 >= 0 && nums2[p2] >= nums1[p1])){
                nums1[resP] = nums2[p2];
                p2--;
            }else{
                nums1[resP] = nums1[p1];
                p1--;
            }
            resP--;
        }
    }
}