package HEAPS;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap(){
        this.list = new ArrayList<>();
    }

    public void add(T val){
        list.add(val);
        upHeap(list.size()-1);
    }

    public void upHeap(int index){
        if(index==0){
            return;
        }

        int parentIndex = parent(index);
        if(list.get(parentIndex).compareTo(list.get(index))>0){
            T temp = list.get(parentIndex);
            list.set(parentIndex,list.get(index));
            list.set(index,temp);
            upHeap(parentIndex);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("It's Empty.");
        }

        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }

        return temp;
    }

    private void downHeap(int index) {
        int min = index;

        if(index==list.size()-1){
            return;
        }

        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        if(list.size()>leftChildIndex&&list.get(leftChildIndex).compareTo(list.get(index))<0){
            min = leftChildIndex;
        }

        if(list.size()>rightChildIndex&&list.get(rightChildIndex).compareTo(list.get(index))<0){
            min = rightChildIndex;
        }

        if(min!=index){
            T temp = list.get(index);
            list.set(index,list.get(min));
            list.set(min,temp);
            downHeap(min);
        }
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private int rightChild(int index){
        return (2*index)+2;
    }

    private int leftChild(int index){
        return (2*index)+1;
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> sortedList = new ArrayList<>();
        while (!this.list.isEmpty()){
            sortedList.add(remove());
        }
        return sortedList;
    }

    public void display(){
        System.out.println(this.list);
    }
}
