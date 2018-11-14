public class Node {

    char key;
    int frequency;
    Node leftChild;
    Node rightChild;


    public Node(char c, int frequency,Node... nodes){
        this.key = c;
        this.frequency = frequency;
        if(nodes.length >= 1)
            this.leftChild = nodes[0];
        if(nodes.length == 2)
            this.rightChild = nodes[1];
    }

    public Node(Tree... trees){
        if(trees.length >= 1)
            this.leftChild = trees[0].getRoot();
        if(trees.length == 2)
            this.rightChild = trees[1].getRoot();
    }


    public void sumFrequency(){

        if(this.leftChild != null && this.rightChild != null)
            this.frequency = leftChild.frequency + rightChild.frequency;
        else if(this.leftChild != null)
            this.frequency = leftChild.frequency;
        else if(this.rightChild != null)
             this.frequency = rightChild.frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}
