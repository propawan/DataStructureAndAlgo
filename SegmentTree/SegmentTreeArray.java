package SegmentTree;

public class SegmentTreeArray {
    public static void main(String[] args) {
        int []arr = {1,3,2,-5,6,4};
        int []tree = new int[4*arr.length+1];
        int []lazy = new int[4*arr.length+1];
        buildTree(arr,0,arr.length-1,tree,1);
//        System.out.println(query(tree,0,2,0,arr.length-1,1));
//        updateIndex(tree, -10,1,0,arr.length-1,0);
//        System.out.println(query(tree,0,5,0,arr.length-1,1));
//        updateRange(tree,0,2,0,arr.length-1,1,10);
//        for (int i = 0; i <= 13; i++) {
//            System.out.println(i+" "+tree[i]);
//        }
        updateLazy(tree,lazy,0,5,0,arr.length-1,1,10);
        System.out.println(queryLazy(tree,lazy,0,5,0,arr.length-1,1));
    }

    public static void buildTree(int []arr,int start,int end,int []tree,int index){
        if(start==end){
            tree[index] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr,start,mid,tree,2*index);
        buildTree(arr,mid+1,end,tree,2*index+1);
        tree[index] = Math.min(tree[2*index],tree[2*index+1]);
    }

    public static int query(int []tree,int qs,int qe,int ns,int ne,int index){
//        Complete overlap
        if(ns>=qs&&ne<=qe){
            return tree[index];
        }

//        Complete outside
        if(qe<=ns||qs>=ne){
            return Integer.MAX_VALUE;
        }

        int mid = (ns+ne)/2;
        int leftAns = query(tree,qs,qe,ns,mid,2*index);
        int rightAns = query(tree,qs,qe,mid+1,ne,2*index+1);
        return Math.min(leftAns,rightAns);
    }

    public static int updateIndex(int []tree,int value,int index,int ns,int ne,int indexToUpdate){
//        index To update is to check which area is to be traversed
//        Like in this base case when the ns and ne are of no use
//        because Index to update is greater than node end and less than node start
        if(indexToUpdate<ns||indexToUpdate>ne){
            return Integer.MAX_VALUE;
        }
        if(ns==ne){
            tree[index] = value;
            return tree[index];
        }
        int mid = (ns+ne)/2;
        int leftAns = updateIndex(tree,value,2*index,ns,mid,indexToUpdate);
        int rightAns = updateIndex(tree,value,2*index+1,mid+1,ne,indexToUpdate);
        tree[index] = Math.min(leftAns,rightAns);
        return tree[index];
    }

    public static void updateRange(int []tree,int qs,int qe,int ns,int ne,int index,int increment){
//        Out of bound case
        if(ns>qe||ne<qs){
            return;
        }
        if(ns==ne){
            tree[index] += increment;
            return;
        }
        int mid = (ns+ne)/2;
        updateRange(tree,qs,qe,ns,mid,2*index,increment);
        updateRange(tree,qs,qe,mid+1,ne,2*index+1,increment);
        tree[index] = Math.min(tree[2*index],tree[2*index+1]);
    }

    public static void updateLazy(int []tree,int []lazy,int qs,int qe,int ns,int ne,int index,int inc){
        if(lazy[index]!=0){
            tree[index] += lazy[index];
            if(ns!=ne){
                lazy[2*index] += lazy[index];
                lazy[2*index+1] += lazy[index];
            }
            lazy[index] = 0;
            return;
        }

        if(ns>qe||ne<qs){
            return;
        }

        if(ns>=qs&&ne<=qe){
            tree[index] += inc;

            if(ns!=ne){
                lazy[2*index] += inc;
                lazy[2*index+1] += inc;
            }
            return;
        }

        int mid = (ns+ne)/2;
        updateLazy(tree,lazy,qs,qe,ns,mid,2*index,inc);
        updateLazy(tree,lazy,qs,qe,mid+1,ne,2*index+1,inc);
        tree[index] = Math.min(tree[2*index],tree[2*index+1]);
    }

    public static int queryLazy(int []tree,int []lazy,int qs,int qe,int ns,int ne,int index){
        if(lazy[index]!=0){
            tree[index] += lazy[index];
            if(ns!=ne){
                lazy[2*index] += lazy[index];
                lazy[2*index+1] += lazy[index];
            }
            lazy[index] = 0;
        }

        if(ns>qe||ne<qs){
            return Integer.MAX_VALUE;
        }

        if(ns>=qs&&ne<=qe){
            return tree[index];
        }

        int mid = (ns+ne)/2;
        queryLazy(tree,lazy,qs,qe,ns,mid,2*index);
        queryLazy(tree,lazy,qs,qe,mid+1,ne,2*index+1);
        return Math.min(tree[2*index],tree[2*index+1]);
    }
}
