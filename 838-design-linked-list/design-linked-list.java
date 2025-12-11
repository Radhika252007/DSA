class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }

    }
    Node head;
    int size = 0;
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index>=size){
            return -1;
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        size++;
        if(head==null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        size++;
        if(head==null){
            head = node;
            return;
        }
        Node temp= head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        size++;
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = node;
        node.next = temp2;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        size--;
        if(index==0){
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp= temp.next;
        }
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */