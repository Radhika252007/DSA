class MinStack {
    ArrayList<Integer> minVals;
    ArrayList<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
        minVals = new ArrayList<>();
    }
    
    public void push(int val) {
        if(stack.size()==0){
            minVals.add(val);
        }
        else{
            if(val <= minVals.get(minVals.size()-1)){
                minVals.add(val);
            }
        }
        stack.add(val);
    }
    
    public void pop() {
        if(stack.size()==0){
            return;
        }
        int val = stack.get(stack.size()-1);
        if(val==minVals.get(minVals.size()-1)){
            minVals.remove(minVals.size()-1);
        }
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        if(minVals.size()==0){
            return -1;
        }
        return minVals.get(minVals.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */