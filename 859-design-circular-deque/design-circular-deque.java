class MyCircularDeque {
    int[] arr;
    int size = 0;
    int front;
    int rear;
    int capacity;
    public MyCircularDeque(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size==arr.length) return false;
        if(front==-1 && rear==-1){
            front = 0;
            rear = 0;
        }
        else{
            front = (front - 1 + capacity) % capacity;
        }
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==arr.length) return false;
         if(front==-1 && rear==-1){
            front = 0;
            rear = 0;
        }
        else{
            rear = (rear + 1) % capacity;
        }
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        if(size==1){
            front = -1;
            rear = -1;
        }
        else{
        front = (front +1) % capacity;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
         if(size==0) return false;
        if(size==1){
            front = -1;
            rear = -1;
        }
        else{
        rear = (rear -1 + capacity) % capacity;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(front==-1) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(rear == -1) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */