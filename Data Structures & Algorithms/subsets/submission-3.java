class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());              // 先放入空集
        for (int num : nums) {
            int size = res.size();               // 先固定住当前长度
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(res.get(i));
                newSubset.add(num);
                res.add(newSubset);
            }
        }
        return res;
    }
}