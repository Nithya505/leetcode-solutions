class MinStack {
    private Deque<Integer>mainstack;
    private Deque<Integer>minstack;


    public MinStack() {
        mainstack=new ArrayDeque<>();
        minstack=new ArrayDeque<>();
        
    }
    
    public void push(int val) {
        mainstack.push(val);
        if(minstack.isEmpty()||val<=minstack.peek()){
            minstack.push(val);
        }else{
            minstack.push(minstack.peek());
        }
        
    }
    
    public void pop() {
        mainstack.pop();
        minstack.pop();
        
    }
    
    public int top() {
        return mainstack.peek();
    }
    
    public int getMin() {
        return minstack.peek();

    }
}
