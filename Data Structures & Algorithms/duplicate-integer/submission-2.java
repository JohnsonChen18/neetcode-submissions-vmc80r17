class Solution {
    // naive: for each num, iterate all other nums and compare
    // Time O(n**2) Space O(1)

    //HashSet
    // Time O(n) Space O(n)

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            // if appears before
            if(set.contains(num)) return true;

            set.add(num);
        }

        return false;
    }
}