package SegmentTree;

public class SegmentTreeArraySum {
    public static void main(String[] args) {
        int []arr = {2,5,-6,9,11,-8};
        int []tree = new int[4*arr.length+1];
        buildTree(arr,tree,0,arr.length-1,1);
        System.out.println(query(tree,0,3,0,arr.length-1,1));
        updateIndex(tree,3,7,0,arr.length-1,1);
        System.out.println(query(tree,0,3,0,arr.length-1,1));
    }

    public static void buildTree(int []arr,int []tree,int start,int end,int index){
        if(start==end){
            tree[index] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr,tree,start,mid,2*index);
        buildTree(arr,tree,mid+1,end,2*index+1);
        tree[index] = tree[2*index] + tree[2*index+1];
    }

    public static int query(int []tree,int qs,int qe,int ns,int ne,int index){
        if(ns>=qs&&ne<=qe){
            return tree[index];
        }

        if(ns>qe||ne<qs){
            return 0;
        }

        int mid = (ns+ne)/2;
        int leftAns = query(tree,qs,qe,ns,mid,2*index);
        int rightAns = query(tree,qs,qe,mid+1,ne,2*index+1);
        return leftAns+rightAns;
    }

    public static void updateIndex(int []tree,int indexToUpdate,int value,int ns,int ne,int index){
        if(ns>indexToUpdate||indexToUpdate>ne){
            return;
        }
        if(ns==ne){
            tree[index] = value;
            return;
        }

        int mid = (ns+ne)/2;
        updateIndex(tree,indexToUpdate,value,ns,mid,2*index);
        updateIndex(tree,indexToUpdate,value,mid+1,ne,2*index+1);
        tree[index] = tree[2*index] + tree[2*index+1];
    }
}
