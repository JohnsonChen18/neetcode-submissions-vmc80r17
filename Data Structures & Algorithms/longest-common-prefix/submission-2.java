class Solution {
    public String longestCommonPrefix(String[] strs) {
        // init
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(String str: strs){
            minLen = Math.min(minLen, str.length());
        }
        
        // main
        for(int i = 0; i < minLen; i++){
            char targetChar = strs[0].charAt(i);

            boolean ifSame = true;
            for(String str: strs){
                if(str.charAt(i) != targetChar){
                    ifSame = false;
                    break;
                }
            }

            if(ifSame == false) break;
            sb.append(targetChar);
        }

        return sb.toString();
    }
}