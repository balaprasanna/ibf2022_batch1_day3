import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * FilesDemo
 */
public class FilesDemo {
    
    public static void main(String[] args) {
        
        String filePath = "src/demo.txt";
        ReadFile(filePath);
        WriteFile("src/output.txt");
    }

    public static void ReadFile(String fname) {
        
        // Path object
        File fobj = Paths.get(fname).toFile();
        try {
            FileReader fr = new FileReader(fname);
            BufferedReader bdf = new BufferedReader(fr);
            String line;
            // String line = bdf.readLine();
            // System.out.println("First line = >" + line);
            while ( (line = bdf.readLine()) != null ) {
                System.out.println("> " + line);
            }

            bdf.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not found. Please check input file: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Unable to read line: " + e.getMessage());
        }

    }

    public static void WriteFile(String fname) {
        try {
            FileWriter fw = new FileWriter(fname, false); // append mode / write mode    
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("apple\n");
            bfw.write("orange\n");
            bfw.write("pear\n");
            
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            System.out.println("Unable to write line: " + e.getMessage());
        }
        
        
        
    }
    
}