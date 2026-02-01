class NumArray {
    Node root;
    public NumArray(int[] nums) {
        // create a tree using this array
        this.root = constructTree(nums,0,nums.length-1);
    }
    private Node constructTree(int[] arr, int start, int end){
        if(start==end){
            //leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;

    }
    
    public void update(int index, int val) {
        setIndex(root,index,val);
    }
    private int setIndex(Node node, int index, int val){
        if(index >= node.startInterval && index <=node.endInterval){
            if(index==node.startInterval && index == node.endInterval){
                node.data = val;
    return node.data;
            }
            else{
                int leftAns = setIndex(node.left,index,val);
                int rightAns = setIndex(node.right,index,val);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
    
    public int sumRange(int left, int right) {
        return getSum(root,left,right);
    }

    private int getSum(Node node, int left, int right){
         if(node.startInterval >=left && node.endInterval<=right){
            return node.data;
        }
        else if(node.endInterval<left || node.startInterval>right){
            return 0;
        }
        
return getSum(node.left,left,right)+getSum(node.right,left,right);
        

    }
    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */