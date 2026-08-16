class MinStack {
    private Deque<Long> stack;  // 存差值，用 Long 防止溢出
    private long min;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);  // 存差值
            if (val < min) min = val;  // 更新最小值
        }
    }

    public void pop() {
        long diff = stack.pop();
        // 差值为负说明这个元素当年就是最小值，弹出后要恢复上一个最小值
        if (diff < 0) min = min - diff;  // min_prev = min_cur - diff
    }

    public int top() {
        long diff = stack.peek();
        // diff >= 0：栈顶原值 = min + diff；diff < 0：栈顶就是当前 min
        return (int) (diff >= 0 ? min + diff : min);
    }

    public int getMin() {
        return (int) min;
    }
}