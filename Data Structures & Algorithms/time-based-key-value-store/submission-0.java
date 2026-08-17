class TimeMap {
    private Map<String, List<Pair>> map;

    static class Pair {
        int timestamp;
        String value;
        Pair(int t, String v) { timestamp = t; value = v; }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) return "";

        int left = 0, right = list.size() - 1;
        String ans = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}