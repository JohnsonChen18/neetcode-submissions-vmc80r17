class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while(left <= right){
            while(left < n && Character.isLetterOrDigit(s.charAt(left)) == false) left++;
            while(right >= 0 && Character.isLetterOrDigit(s.charAt(right)) == false) right--;

            if (left > right) break;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;

        }

        return true;

    }
}
