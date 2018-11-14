import java.util.HashMap;

public class Huffman {
    HashMap<Character,String> code = new HashMap<Character,String>();
    String input;
    String encoded;
    String decoded;
    public Huffman(PriorityQueue pq){
        this.input  = pq.input;
        while(pq.getnItems() != 1) {
            Tree firstTree = pq.remove();
            Tree secondTree = pq.remove();

            Node node = new Node(firstTree,secondTree);
            Tree newTree = new Tree(node);
            pq.insert(newTree);
        }
        createCode(pq.getQueueArray()[0].getRoot(),"");
    }

    public void createCode(Node node, String s)
    {


        if (node.leftChild == null && node.rightChild == null) {
            if(node.key != '\u0000')
            code.put(node.key,s);
           // System.out.println(node.key + ":" + s); //Debug to make sure codes are correct
            return;
        }

        if(node.leftChild != null){
            createCode(node.leftChild, s + "0");
        }
        if(node.rightChild != null){
            createCode(node.rightChild, s + "1");}
    }

    public String encode(){
        StringBuilder sb = new StringBuilder();
        for (char c: input.toCharArray()) {
            sb.append(code.get(c) + " ");
        }
        encoded = sb.toString();
        return encoded;
    }

    public String decode(){
        StringBuilder sb = new StringBuilder();
        String[] split = encoded.split(" ");
        for (String s:split){
            for(HashMap.Entry<Character,String> entry : code.entrySet()){
                if(s.equals(entry.getValue()))
                    sb.append(entry.getKey());
            }
        }

        decoded = sb.toString();
        return decoded;
    }




}
