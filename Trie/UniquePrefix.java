package Trie;

import java.util.HashMap;

public class UniquePrefix {
    public static class Trie{
        private Node root;

        public Trie(){
            this.root = new Node('\0');
        }

        private class Node{
            char value;
            HashMap<Character,Node> children;
            int count;
            boolean isTerminal;
            public Node(char val){
                this.value = val;
                this.children = new HashMap<>();
                this.count = 0;
                this.isTerminal = false;
            }
        }

        public void insert(String word){
            Node temp = this.root;
            for (char ch:word.toCharArray()) {
                if(temp.children.containsKey(ch)){
                    temp = temp.children.get(ch);
                    temp.count += 1;
                }
                else{
                    Node child = new Node(ch);
                    child.count += 1;
                    temp.children.put(ch,child);
                    temp = child;
                }
            }
            temp.isTerminal = true;
        }

        public String computePrefix(String word){
            StringBuilder builder = new StringBuilder();
            Node temp = this.root;
            int counter = 0;
            boolean flag = false;
            for (char ch:word.toCharArray()) {
                if(temp.children.containsKey(ch)){
                    temp = temp.children.get(ch);
                    builder.append(temp.value);
                    counter++;
                    if(temp.count==1){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag&&counter>0&&counter<=word.length()){
                return builder.toString();
            }
            else{
                return "-1";
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"zebra","zebras","dog","dove","duck"};
        for (String word:words) {
            trie.insert(word);
        }
        for (String word:words) {
            System.out.println(trie.computePrefix(word));
        }
    }
}
