class LFUCache {
    class Node{
        int key,val,freq;
        Node next,tail,prev;
        Node(int k,int v){
            key=k;
            val=v;
            freq=1;
        }
    }
    class DoublyLinkedList{
        Node head,tail;
        int size=0;
        DoublyLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.next=head;

        }
        void add(Node node){
            Node nxt=head.next;
            head.next=node;
            node.prev=head;
            node.next=nxt;
            nxt.prev=node;
            size++;
        }
        void remove(Node node){
            Node prev=node.prev;
            Node nxt=node.next;
            prev.next=nxt;
            nxt.prev=prev;
            size--;
        }
        Node removeLast(){
            if(size==0)return null;
            Node last=tail.prev;
            remove(last);
            return last;
        }
    }
    int capacity,minfreq;
    Map<Integer,Node>keyMap;
    Map<Integer,DoublyLinkedList>freqMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minfreq=0;
        keyMap=new HashMap<>();
        freqMap=new HashMap<>();

   }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node=keyMap.get(key);
        updatefreq(node);
        return node.val; 
        
        
    }
    
    public void put(int key, int value) {
        if(capacity==0)return;
        if(keyMap.containsKey(key)){
            Node node=keyMap.get(key);
            node.val=value;
            updatefreq(node);
        }else{
            if(keyMap.size()==capacity){
                DoublyLinkedList minlist=freqMap.get(minfreq);
                Node evict=minlist.removeLast();
                keyMap.remove(evict.key);
            }
            Node newNode=new Node(key,value);
            keyMap.put(key,newNode);
            freqMap.computeIfAbsent(1,z->new DoublyLinkedList()).add(newNode);
            minfreq=1;
        }
        
    }
    private void updatefreq(Node node){
        int oldfreq=node.freq;
        freqMap.get(oldfreq).remove(node);
        if(oldfreq==minfreq&&freqMap.get(oldfreq).size==0){
            minfreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq,z->new DoublyLinkedList()).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */