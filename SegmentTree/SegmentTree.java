package SegmentTree;

public class SegmentTree {
    Node root;

    public SegmentTree(int []arr){
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int []arr,int start,int end) {
        if(start==end){
            Node leafNode = new Node();
            leafNode.data = arr[start];
            leafNode.startInterval = start;
            leafNode.endInterval = end;
            return leafNode;
        }

        Node node = new Node();
        node.startInterval = start;
        node.endInterval = end;

        int mid = (start+end)/2;
        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid+1,end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){
        String str = "";
        if(node.left!=null){
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and Data = " + node.left.data + "->";
        }
        else{
            str += "No left child ->";
        }

        str += "Interval=[" + node.startInterval + "-" + node.endInterval + "] and Data = " + node.data;

        if(node.right!=null){
            str += "<- Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and Data = " + node.right.data;
        }
        else{
            str += "<- No right child";
        }

        System.out.println(str);

        if(node.left!=null){
            this.display(node.left);
        }
        if(node.right!=null){
            this.display(node.right);
        }
    }

    public int query(int start,int end){
        return this.query(this.root,start,end);
    }

    private int query(Node node, int start, int end) {
//        completely lying inside case
//        Query-> (2,6), node-> (4,5)
        if(node.startInterval>=start&&node.endInterval<=end){
            return node.data;
        }

//        completely lying outside case
//        Query-> (2,6), node-> (7,7) or node-> (0,0)
        else if(node.startInterval>end||node.endInterval<start){
            return 0;//return default value
        }

//        Overlapping case
//        Query-> (2,6), node-> (0,7) or node-> (0,3)
        else{
            int leftAns = this.query(node.left,start,end);
            int rightAns = this.query(node.right,start,end);
            return leftAns + rightAns;
        }
    }

    public void update(int index,int value){
        this.root.data = update(this.root,index,value);
    }

    private int update(Node node, int index, int value) {
        if(index>=node.startInterval&&index<=node.endInterval){
            if(index==node.startInterval&&node.endInterval==index){
                node.data = value;
            }
            else{
                int leftValue = this.update(node.left,index,value);
                int rightValue = this.update(node.right,index,value);
                node.data = leftValue+rightValue;
            }
        }
        return node.data;
    }

    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
    }
}
