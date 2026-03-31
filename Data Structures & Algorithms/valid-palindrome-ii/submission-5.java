class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1, 1);
    }

    private boolean check(String s, int start, int end, int remainDel){
        if(start >= end) return true;

        int left = start;
        int right = end;

        while (left <= right){
            // match
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }

            // dosent match
            // run out of del
            if(remainDel == 0) return false;

            // try del left or right
            boolean delLeftRes = check(s, left+1, right, remainDel - 1);
            boolean delRightRes = check(s, left, right-1, remainDel - 1);

            return delLeftRes || delRightRes;

        }
        
        return true;
    }
}