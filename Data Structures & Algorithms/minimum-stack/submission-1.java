class MinStack {
    long min;
    private Deque<Long> mStack;
    public MinStack() {
        mStack = new ArrayDeque<Long>();
    }
    
    public void push(int val) {
        if(mStack.isEmpty()){
            mStack.push(0L);
            min = val;
        } else {
            mStack.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(mStack.isEmpty()) return;

        long pop = mStack.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        if(mStack.peek() > 0){
            return (int)(min + mStack.peek());
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
