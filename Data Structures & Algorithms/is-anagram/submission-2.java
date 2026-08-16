class Solution {
    public boolean isAnagram(String s, String t) {
        // init
        int n = s.length();
        int m = t.length();
        int[] arr = new int[26];
        if (n != m) return false;

        // main
        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a'] += 1;
            arr[t.charAt(i) - 'a'] -= 1;
        }

        // check
        for(int num: arr){
            if(num != 0) return false;
        }

        return true;
    }
}
