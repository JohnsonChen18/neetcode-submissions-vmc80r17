class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "+": {
                    int top = stack.pop();          // 先弹出最上面的
                    int newTop = top + stack.peek(); // 加上下一个（不弹出）
                    stack.push(top);                 // 把弹出的放回去
                    stack.push(newTop);
                    break;
                }
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int x : stack) sum += x;
        return sum;
    }
}