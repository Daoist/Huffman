import org.apache.commons.io.FilenameUtils;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
//C:\Users\Mrah\Desktop\susie.txt


public class FileHandler {
    private File textFile;
    private File binFile;
    String path;
    String herpderp;
    String derpherp;

    FileHandler(String path) {
        this.path = path;
        String ext = FilenameUtils.getExtension(path);
        if (ext.equals("txt")) {
            textFile = new File(path);
            readTextFile(path);
        }
        else if (ext.equals(".bin")) {
            binFile = new File(path);
            readBinaryFile();
        }
        else {
            System.out.println("Invalid file type, must be a .bin or .txt");
            System.exit(1);
        }
    }

    public void writeFile(String path, BitSet set) {
        try {
            FileOutputStream fos = new FileOutputStream(path.substring(0, path.length() - ".txt".length()) + ".bin");
            fos.write(set.toByteArray());
            fos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing file: " + e.getMessage());
        }
    }

    public  String readTextFile(String path) {
        String inputText = "";
        try {
            inputText = new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
        herpderp = inputText;
        return inputText;
    }


    public String readBinaryFile() {
        String binaryString = "";
        byte[] buffer;
        BitSet codeSet = null;
        try {
            buffer = Files.readAllBytes(Paths.get(path));
            codeSet = BitSet.valueOf(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
            for (int i = 0; i <= codeSet.length(); i++) {
                if (codeSet.get(i)) {
                    binaryString += "1";
                } else {
                    binaryString += "0";
                }
            }
            derpherp = binaryString;
            return binaryString;
    }
}
