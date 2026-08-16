class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // init
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        //main
        for(String str: strs){
            String currCode = getCode(str);
            if(map.containsKey(currCode) == false) map.put(currCode, new ArrayList<>());
            map.get(currCode).add(str);
        }

        // return
        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    private String getCode(String s){
        // init
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();

        // main
        for(char c: s.toCharArray()){
            arr[c- 'a'] += 1;
        }
        for(int num: arr){
            sb.append(String.valueOf(num));
            sb.append(':');
        }
        
        return sb.toString();
    }
}
