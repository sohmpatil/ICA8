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
        ArrayList<Integer> outputNumbers;
        line = readFile(INPUT_FILE);
        outputNumbers = processInput(line);
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

    public static ArrayList<Integer> processInput(ArrayList<String> line) {
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < line.size(); i++) {
            String urinals = line.get(i);
            int totalUrinals = urinals.length();
            int count;
            count = 0;

            for (int j = 1; j < totalUrinals - 1; j++) {
                if (urinals.charAt(j - 1) == '0' && urinals.charAt(j + 1) =='0' && urinals.charAt(j) == '0') {
                    count++;
                    StringBuilder string = new StringBuilder(urinals);
                    string.setCharAt(i, '1');
                    urinals = String.valueOf(string);
                }
            }

            if (urinals.charAt(totalUrinals - 1) == '0' && urinals.charAt(totalUrinals - 2) == '0') {
                count++;
            }

            output.add(count);
        }
        return output;
    }

}