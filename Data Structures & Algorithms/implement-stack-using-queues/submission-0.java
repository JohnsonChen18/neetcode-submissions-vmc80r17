public class MyStack {
    private Queue<Object> q;

    public MyStack() {
        q = null;
    }

    public void push(int x) {
        Queue<Object> newQueue = new LinkedList<>();
        newQueue.add(x);
        newQueue.add(q);
        q = newQueue;
    }

    public int pop() {
        if (q == null) return -1;

        int top = (int) q.poll();
        q = (Queue<Object>) q.poll();
        return top;
    }

    public int top() {
        if (q == null) return -1;
        return (int) q.peek();
    }

    public boolean empty() {
        return q == null;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */