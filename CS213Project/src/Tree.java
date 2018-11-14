public class Tree {

    private Node root;

    public Tree(Node... nodes){
        root = nodes[0];
        if (nodes.length >= 2)
            root.leftChild = nodes[1];
        if (nodes.length == 3)
            root.rightChild = nodes[2];
        root.sumFrequency();

    }


    public Node getRoot() {
        return root;
    }



}
