import java.util.HashMap;

public class PriorityQueue {

    private Tree[] queueArray;
    private int nItems;
    private int count;
    public String input;

    public PriorityQueue(String input){
        this.input = input;
        createTrees(input);
    }



    public void createTrees(String input){
        HashMap<Character,Integer> frequencies = new HashMap<>();
        Tree[] trees = new Tree[input.length()];

        for (char ch : input.toCharArray())
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);

        for(HashMap.Entry<Character,Integer> entry : frequencies.entrySet()){

            Node node = new Node(entry.getKey(),entry.getValue());
            Tree tree = new Tree(node);
            trees[count] = tree;
            count++;
        }
        createPriorityQueue(trees);
    }

    public void createPriorityQueue(Tree[] trees){
        queueArray = new Tree[count];
        nItems = 0;
        for (int i = 0; i < count; i++) {
            insert(trees[i]);
        }
    }


    public void insert(Tree item){
        int value = item.getRoot().getFrequency();
        int j;

        if(nItems == 0)
            queueArray[nItems++] = item;
        else{
            for(j = nItems - 1; j >= 0; j--){
                if(value > queueArray[j].getRoot().getFrequency()){
                    queueArray[j+1] = queueArray[j];
                }
                else
                    break;
            }
            queueArray[j+1] = item;
            nItems++;
        }

    }

    public Tree remove(){
        return queueArray[--nItems];
    }

    public Tree[] getQueueArray() {
        return queueArray;
    }

    public int getnItems() {
        return nItems;

    }
}


