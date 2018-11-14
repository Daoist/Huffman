public class Main {

    public static void main(String[] args) {
	    String test1 = "susie says it is easy";
        PriorityQueue pq = new PriorityQueue(test1);
        Huffman hTree1 = new Huffman(pq);

        System.out.println("Encoding string: \"Susie says it is easy\"");
        System.out.println(hTree1.encode());
        System.out.println("Decoding values: \"" + hTree1.encoded + "\"");
        System.out.println(hTree1.decode());




        Byte[] derp = new Byte[16];
        derp[0] = 10;



    }
}
