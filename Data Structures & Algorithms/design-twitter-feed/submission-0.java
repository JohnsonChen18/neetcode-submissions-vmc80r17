class Twitter {
    private int timestamp = 0;
    // userId -> 该用户发的推文列表,每项是 {时间戳, tweetId}
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    // userId -> 关注的人集合
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // 大根堆:按时间戳从大到小
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // 候选人 = 自己 + 关注的人
        Set<Integer> candidates = new HashSet<>();
        candidates.add(userId);
        if (follows.containsKey(userId)) {
            candidates.addAll(follows.get(userId));
        }

        // 把每个候选人的“最新一条”推文放进堆
        for (int uid : candidates) {
            List<int[]> list = tweets.get(uid);
            if (list != null && !list.isEmpty()) {
                int idx = list.size() - 1;              // 最新的在末尾
                // 存 {时间戳, tweetId, 属于谁, 在其列表中的下标}
                heap.offer(new int[]{list.get(idx)[0], list.get(idx)[1], uid, idx});
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < 10) {
            int[] top = heap.poll();
            res.add(top[1]);                            // 取出 tweetId

            int uid = top[2], idx = top[3];
            if (idx > 0) {                              // 该用户还有更早的推文
                int[] prev = tweets.get(uid).get(idx - 1);
                heap.offer(new int[]{prev[0], prev[1], uid, idx - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}