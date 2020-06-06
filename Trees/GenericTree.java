package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

    private Node root;

    private class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public void takeInput(){
        Scanner sc = new Scanner(System.in);
        this.root = takeInput(sc,null);
    }

    public Node takeInput(Scanner sc,Node parent){
        if(parent == null){
            System.out.println("Enter value of root node: ");
            int num = sc.nextInt();
            parent = new Node(num);
        }
        while (true){
            System.out.println("Enter children value for node: "+parent.data+" ?.");
            boolean choice = sc.nextBoolean();
            if(choice){
                System.out.println("Enter value of child: ");
                int value = sc.nextInt();
                Node childNode = new Node(value);
                parent.children.add(childNode);
                takeInput(sc,childNode);
            }
            else{
                break;
            }
        }

        return parent;
    }

    public void display(){
        display(this.root,"");
    }

    public void display(Node node, String indent){
        if (node==null){
            return;
        }
        System.out.println(indent+"->"+node.data);
        for (Node child:node.children) {
            display(child,indent+"  ");
        }
    }

    public int countNodes(){
        return countNodes(this.root);
    }

    private int countNodes(Node node) {
        int count = 1;
        for (Node child:node.children) {
            count += countNodes(child);
        }
        return count;
    }

    public int height(){
        return height(this.root);
    }

    private int height(Node node) {
        int maxHeight = 0;
        for (Node child:node.children) {
            int height = height(child);
            maxHeight = Math.max(height,maxHeight);
        }
        return maxHeight+1;
    }

    public void depth(int k){
        if(k==0){
            System.out.println("Node at depth k: "+this.root.data);
            return;
        }
        depth(this.root,k);
    }

    public void depth(Node node,int k){
        if(node==null){
            return;
        }
        if(k==0){
            System.out.println("Node at depth k: "+ node.data);
            return;
        }
        for (Node child:node.children) {
            depth(child,k-1);
        }
    }

    public int max(){
        int maximum = this.root.data;
        return max(this.root,maximum);
    }

    private int max(Node node, int maximum) {
        if(node.data>maximum){
            maximum = node.data;
        }
        for (Node child:node.children) {
            maximum = max(child,maximum);
        }
        return maximum;
    }

    public void levelOrderTraversal(){
        Queue<Node> queue = new LinkedList<>();
        levelOrderTraversal(this.root,queue);
    }

    public void levelOrderTraversal(Node node,Queue<Node> queue){
        queue.add(node);
        while (!queue.isEmpty()){
            Node curr = queue.remove();
            System.out.print(curr.data+" ");
            queue.addAll(curr.children);
        }
        System.out.println();
    }

}
