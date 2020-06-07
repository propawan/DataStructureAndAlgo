package Trees;

import java.util.Scanner;

public class BinaryTree {
    private Node root = null;

    private class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        this.root = input(sc, this.root);
    }

    public Node input(Scanner sc, Node node) {
        if (node == null) {
            System.out.println("Enter the value of node:");
            int val = Integer.parseInt(sc.nextLine());
            return new Node(val);
        }
        System.out.println("In which direction you want to put the value of child node for: " + node.value);
        String dir = sc.nextLine();
        if (dir.toLowerCase().charAt(0) == 'l') {
            node.left = input(sc, node.left);
        } else if (dir.toLowerCase().charAt(0) == 'r') {
            node.right = input(sc, node.right);
        }
        return node;
    }

    public void display() {
        String indent = "";
        display(this.root, indent);
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + "->" + node.value);
        display(node.left, indent + "  ");
        display(node.right, indent + "  ");
    }

    public int height(){
        return height(this.root);
    }

    public int height(Node node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
    }

    public boolean find(int val){
        return find(this.root,val);
    }

    public boolean find(Node node,int val){
        if(node==null){
            return false;
        }
        if(node.value==val){
            return true;
        }
        return find(node.left, val) || find(node.right, val);
    }

    public int diameter(){
        return diameter(this.root);
    }

    public int diameter(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int current = 1+leftHeight+rightHeight;
        return Math.max(current,Math.max(diameter(node.left),diameter(node.right)));
    }
}
