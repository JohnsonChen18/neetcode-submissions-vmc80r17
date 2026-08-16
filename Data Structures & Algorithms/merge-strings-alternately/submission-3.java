class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int p1 = 0;
        int p2 = 0;

        while(p1 < len1 && p2 < len2){
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }

        if(p1 == len1) sb.append(word2.substring(p2, len2));
        if(p2 == len2) sb.append(word1.substring(p1, len1));

        return sb.toString();
    }
}