class StockSpanner {
    ArrayList<Integer> list;
    Stack<Integer> st;
    public StockSpanner() {
        list = new ArrayList<>();
        st = new Stack<>();
    }
    
    public int next(int price) {
        while(!st.isEmpty() && list.get(st.peek()) <= price){
            st.pop();
        }
        int size = list.size();
        int ans  = (st.isEmpty() ? size + 1 : list.size()  - st.peek());
        list.add(price);
        st.push(size);
        return ans;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */