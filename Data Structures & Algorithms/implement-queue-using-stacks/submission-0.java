class MyQueue {
    private Deque<Integer> in;   // 输入栈
    private Deque<Integer> out;  // 输出栈

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        in.push(x);              // 直接压入输入栈
    }

    public int pop() {
        transfer();              // 保证 out 有数据
        return out.pop();
    }

    public int peek() {
        transfer();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    // 只有 out 为空时，才把 in 全部倒进 out
    private void transfer() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */