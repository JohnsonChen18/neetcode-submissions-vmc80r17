class Solution {
    public String minWindow(String s, String t) {
        // check
        if(s.length() < t.length()) return "";

        //init
        int missing = t.length();
        int[] need = new int[58];
        for(char c: t.toCharArray()){
            need[c - 'A'] += 1;
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = -1;

        for(int right = 0; right < s.length(); right++){
            int charIdx = s.charAt(right) - 'A';
            if (need[charIdx] > 0){
                missing -= 1;
                need[charIdx] -= 1;
            }else{
                need[charIdx] -= 1;
            }

            while(missing == 0 && left <= right){
                int currLen = right - left + 1;
                if(currLen < minLen){
                    minLen = currLen;
                    start = left;
                    end = right;
                }
                need[s.charAt(left) - 'A'] += 1;
                if(need[s.charAt(left) - 'A'] > 0) missing += 1;
                left += 1;
            }
        }
        return s.substring(start,end+1);
    }
}
