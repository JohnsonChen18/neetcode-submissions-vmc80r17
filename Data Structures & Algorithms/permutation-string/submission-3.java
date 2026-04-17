class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int match = 0;
        int left = 0;
        int right = s1.length()-1;

        for(char c: s1.toCharArray()){
            arr1[c - 'a']++;
        }

        for(int i = 0; i <= right; i++){
            arr2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0;i < 26; i++){
            if(arr1[i] == arr2[i]) match++;
        }

        while(right < s2.length()){
            if(match == 26) return true;
            if(arr1[s2.charAt(left) - 'a'] == arr2[s2.charAt(left) - 'a']) match--;
            arr2[s2.charAt(left) - 'a']--;
            if(arr1[s2.charAt(left) - 'a'] == arr2[s2.charAt(left) - 'a']) match++;
            left++;
            right++;
            if(right < s2.length()){
                if(arr1[s2.charAt(right) - 'a'] == arr2[s2.charAt(right) - 'a']) match--;
                arr2[s2.charAt(right) - 'a']++;
                if(arr1[s2.charAt(right) - 'a'] == arr2[s2.charAt(right) - 'a']) match++;
            }
        }   
        return false;
    }
}
