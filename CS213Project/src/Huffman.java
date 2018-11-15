import java.util.BitSet;
import java.util.HashMap;

public class Huffman {
    HashMap<Character,String> code = new HashMap<Character,String>();
    String input;
    String encoded;
    String decoded;
    BitSet codeSet;


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
            sb.append(code.get(c));
        }
        encoded = sb.toString();
        compress();
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

    public void decode(Node hTree, String str){
        StringBuilder sb = new StringBuilder(str);
        for (Character c:str.toCharArray()) {
            if (hTree.leftChild == null && hTree.rightChild == null) {
                if(hTree.key != '\u0000')
                    sb.append(hTree.key);
                return;
            }
            if(c == '0'){
                createCode(hTree.leftChild, sb.toString());
            }
            if(c == '1'){
                createCode(hTree.rightChild, sb.toString());
            }
        }
    }


    public void compress(){

        codeSet = new BitSet(encoded.length());
        int count = 0;
        for(Character c : encoded.toCharArray()) {
            if(c.equals('1')) {
                codeSet.set(count);
            }
            count++;
        }

    }

    public Node reconstructTree(String s){





        return null;
    }



}
