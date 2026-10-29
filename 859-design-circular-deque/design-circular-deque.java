class MyCircularDeque {
    int front;
    int rear;
    int[] arr;
    int k;
    int size;
    public MyCircularDeque(int k) {
        front = -1;
        rear = -1;
        arr = new int[k];
        this.k = k;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(size == k) return false;
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else{
            front = (front - 1 + k) % k;
        }
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == k) return false;
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else{
            rear = (rear + 1) % k;
        }
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(front == -1) return false;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
        front = (front + 1) % k;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(rear == -1) return false;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
            rear = (rear - 1 + k) % k;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return size == k;
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