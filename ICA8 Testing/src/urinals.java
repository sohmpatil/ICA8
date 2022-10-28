import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Soham Prabhakar Patil
 *
 */
public class urinals {
    public static final String INPUT_FILE = "res/urinals.dat";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> line;
        line = readFile(INPUT_FILE);
    }
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        FileReader file = new FileReader(fileName);
        ArrayList<String> list = new ArrayList<>();
        Scanner line = new Scanner(file);
        while (line.hasNextLine()) {
            list.add(line.nextLine());
        }
        return list;
    }

}