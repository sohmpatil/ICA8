import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Soham Prabhakar Patil
 *
 */
public class urinals {
    public static final String INPUT_FILE = "res/urinals.dat";
    public static final String LENGTH_REGEX = "^[0-1]{1,20}$";
    public static final String SIDE_REGEX = "11";

    public static void main(String[] args) throws IOException {
        ArrayList<String> line;
        ArrayList<Integer> outputNumbers;
        line = readFile(INPUT_FILE);
        outputNumbers = processInput(line);
        writeOutput(outputNumbers);
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
            if (!checkIfValidString(line.get(i))) {
                output.add(-1);
            } else {
                int x = maxOpenUrinals(line.get(i));
                output.add(x);
            }
        }
        return output;
    }

    public static int maxOpenUrinals(String lines) {
        int cnt = 0;
        int itr;
        StringBuilder line = new StringBuilder(lines);

        if(line.length() == 1 && line.charAt(0) == '0') {
            return 1;
        }

        if(line.length() == 2 && ((line.charAt(0) == '0') & (line.charAt(1) == '0'))) {
            return 1;
        }

        if ((line.charAt(0) == '0' ) && (line.charAt(1) == '0')) {
            line.setCharAt(0, '1');
            cnt++;
        }

        for (itr = 1; itr < line.length() - 1; itr++) {
            if (line.charAt(itr) == '0' && (line.charAt(itr-1) == '0') & (line.charAt(itr+1) == '0')) {
                cnt++;
                line.setCharAt(itr, '1');
            }
        }

        if (line.charAt(line.length() - 1) == '0' && line.charAt(line.length() - 2) == '0') {
            cnt++;
            line.setCharAt(itr, '1');
        }

        return cnt;
    }

    public static boolean checkIfValidString(String lines) {
        Pattern lengthPattern = Pattern.compile(LENGTH_REGEX);
        Pattern sidePattern = Pattern.compile(SIDE_REGEX);

        Matcher lengthMatcher = lengthPattern.matcher(lines);
        Matcher sideMatcher = sidePattern.matcher(lines);

        return lengthMatcher.find() & !sideMatcher.find();
    }


    public static void writeOutput(ArrayList<Integer> outputNumbers) throws IOException {
        File f = new File("res/rule.txt");
        FileWriter writer = new FileWriter(f);
        for (int i : outputNumbers) {
            writer.write(String.valueOf(i));
            writer.write("\n");
        }
        writer.close();
    }
}