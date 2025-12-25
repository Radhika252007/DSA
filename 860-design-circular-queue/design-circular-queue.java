class MyCircularQueue {
    int size = 0;
    int capacity;
    Node head;
    Node tail;
    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(size==capacity) return false;
        Node node = new Node(value);
        size++;
        if(head==null){
            head = node;
            head.next = head;
            tail = head;
            return true;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0) return false;
        if(size==1){
            head = null;
            tail = null;
            size--;
            return true;
        }
        tail.next = head.next;
        head = head.next;
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(size==0) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */