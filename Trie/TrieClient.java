package Trie;

public class TrieClient {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("Hello");
        tr.insert("world");
        tr.insert("Book");
        tr.insert("world");
        System.out.println(tr.find("Hello"));
        System.out.println(tr.find("Love"));
        System.out.println(tr.find("world"));
        System.out.println(tr.find("World"));
        System.out.println(tr.find("Book"));
        System.out.println("Number of words in Trie are: "+tr.countWords());
        tr.display();
    }
}
