class NumArray {
    class Node{
        int val;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root;
    public NumArray(int[] nums) {
        this.root = constructTree(nums, 0, nums.length-1);
    }
    private Node constructTree(int[] arr, int start, int end){
        if(start==end){
            Node newNode = new Node(start,end);
            newNode.val = arr[start];
            return newNode;
        }
        Node node = new Node(start,end);
        int mid = start + (end - start) / 2;
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        node.val = node.left.val + node.right.val;
        return node;
    }
    public int sumRange(int left, int right) {
        if(root==null) return 0;
        return getSum(root,left,right);
    }
    private int getSum(Node node, int left, int right){
        if(node.startInterval >=left && node.endInterval <=right){
            return node.val;
        }
        if(node.endInterval < left || node.startInterval > right){
            return 0;
        }
        return getSum(node.left,left,right) +getSum(node.right,left,right);
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */