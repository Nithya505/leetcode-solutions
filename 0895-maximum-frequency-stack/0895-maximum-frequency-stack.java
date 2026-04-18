class FreqStack {
    private Map<Integer,Integer>freq;
    private Map<Integer,Stack<Integer>>group;
    private int maxFreq;



    public FreqStack() {
        freq=new HashMap<>();
        group=new HashMap<>();
        maxFreq=0;
        
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        if(!group.containsKey(f)){
            group.put(f,new Stack<>());
        }
        group.get(f).push(val);
        if(f>maxFreq)
        maxFreq=f;
        
    }
    
    public int pop() {
        Stack<Integer>Stack=group.get(maxFreq);
        int val=Stack.pop();
        freq.put(val,freq.get(val)-1);
        if(Stack.isEmpty())maxFreq--;
        return val;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */