package Trie;

import java.util.HashMap;

public class Trie {
    private Node root;
    private int count=0;

    public Trie(){
        this.root = new Node('\0');
    }

    private class Node{
        char data;
        HashMap<Character,Node> children;
        boolean isTerminal;

        public Node(char data){
            this.data = data;
            this.children = new HashMap<>();
            this.isTerminal = false;
        }
    }

    public void insert(String word){
        Node temp = this.root;
        for (char ch:word.toCharArray()) {
            if(temp.children.containsKey(ch)){
                temp = temp.children.get(ch);
            }
            else{
                Node node = new Node(ch);
                temp.children.put(ch,node);
                temp = node;
            }
        }
        if(!temp.isTerminal){
            temp.isTerminal = true;
            this.count++;
        }
    }

    public boolean find(String word){
        Node temp = this.root;
        for (char ch:word.toCharArray()) {
            if(!temp.children.containsKey(ch)){
                return false;
            }
            else{
                temp = temp.children.get(ch);
            }
        }
        return temp.isTerminal;
    }

    public int countWords(){
        return this.count;
    }

    public void display(){
        display(this.root,"");
    }

    private void display(Node node,String processed) {
        if(node.isTerminal){
            System.out.println(processed);
        }
        for (char ch:node.children.keySet()) {
            display(node.children.get(ch),processed+ch);
        }
    }
}
