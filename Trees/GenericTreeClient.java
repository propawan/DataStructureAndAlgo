package Trees;

public class GenericTreeClient {
    public static void main(String[] args) {
        GenericTree tree = new GenericTree();
        tree.takeInput();
        tree.display();
        System.out.println(tree.countNodes());
        System.out.println(tree.height());
        tree.depth(2);
        System.out.println(tree.max());
        tree.levelOrderTraversal();
    }
}
