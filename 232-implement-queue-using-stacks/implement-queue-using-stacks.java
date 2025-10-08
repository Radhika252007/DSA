class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int removed = helper.pop();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return removed;
    }
    
    public int peek() {
       while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int peek = helper.peek();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return peek;
    }
    
    public boolean empty() {
        return stack.isEmpty();
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