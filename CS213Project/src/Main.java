import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    String test1 = "susie says it is easy";
        PriorityQueue pq = new PriorityQueue(test1);
        Huffman hTree1 = new Huffman(pq);

        System.out.println("Encoding string: \"Susie says it is easy\"");
        System.out.println(hTree1.encode());
        System.out.println("Decoding values: \"" + hTree1.encoded + "\"");
        System.out.println(hTree1.decode());


        /*String filepath;    //The file path

        filepath = JOptionPane.showInputDialog("Enter a file path: ");
        //Check file type
        if(!filepath.endsWith(".txt") && !filepath.endsWith(".bin")){
            JOptionPane.showMessageDialog(null,"Invalid file path, selected file must be a .txt file or .bin file");
            System.exit(0);
        }

        //If user exits without entering anything
        if(filepath == null){
            JOptionPane.showMessageDialog(null, "Exiting");
            System.exit(0);
        }

        FileHandler file = new FileHandler(filepath);
        PriorityQueue pq2 = new PriorityQueue(file.herpderp);
        Huffman hTree2 = new Huffman(pq2);
        hTree2.encode();
        hTree2.compress();
        file.writeFile(file.path,hTree2.codeSet);*/
        //String filepath = "C:\\Users\\Mrah\\Desktop\\susie.bin";
        //FileHandler file = new FileHandler(filepath);


        System.out.println("Derp");





    }
}
