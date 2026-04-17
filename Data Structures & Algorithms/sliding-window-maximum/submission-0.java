class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // init
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int[] arr = new int[20001];
        int left = 0;
        for(int i = 0; i < k-1; i++){
            if(arr[nums[i]+10000] == 0) maxHeap.offer(nums[i]);
            arr[nums[i]+10000]++;
        }

        for(int right = k-1; right < nums.length; right++) {
            int currNum = nums [right];
            if(arr[currNum+10000] == 0) maxHeap.offer(currNum);
            arr[currNum+10000] += 1;

            while(arr[maxHeap.peek()+10000] == 0) maxHeap.poll();
            res[left] = maxHeap.peek();

            arr[nums[left] + 10000] -= 1;
            left ++;
        }

        return res;
    }
}
