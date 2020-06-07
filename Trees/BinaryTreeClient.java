package Trees;

public class BinaryTreeClient {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.input();
        tree.input();
        tree.input();
        tree.input();
        tree.input();
        tree.input();
        tree.input();
        tree.display();
        System.out.println(tree.height());
        System.out.println(tree.find(50));
    }
}
