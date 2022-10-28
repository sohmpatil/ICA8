import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void readFileNotFoundExceptionTest() {
        urinals u = new urinals();
        String check = "mockFileName";
        try {
            u.readFile(check);
        } catch (final FileNotFoundException e) {
            assertEquals("mockFileName (No such file or directory)", e.getMessage());
            System.out.println("====== Soham Prabhakar Patil == TEST ONE EXECUTED =======");
        }
    }

    @org.junit.jupiter.api.Test
    void urinalFileExistsTest() {
        urinals u = new urinals();
        String check = "res/urinals.dat";
        try {
            u.readFile(check);
            System.out.println("====== Soham Prabhakar Patil == TEST TWO EXECUTED =======");
        } catch (final FileNotFoundException e) {
            assertEquals("res/urinals.dat (No such file or directory)", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void countUrinals() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> ans;
        ArrayList<Integer> trial = new ArrayList<>();
        list.add(("1111"));
        list.add(("10101"));
        list.add(("0101001010"));
        list.add(("0101001010100101011"));
        list.add(("10101101011010110101"));
        list.add(("1010100101010101010101010000101001"));
        list.add(("asd"));
        list.add(("12345"));
        trial.add(-1);
        trial.add(0);
        trial.add(0);
        trial.add(-1);
        trial.add(-1);
        trial.add(-1);
        trial.add(-1);
        trial.add(-1);
        urinals u = new urinals();
        ans = u.processInput(list);
        assertEquals(ans, trial);
        System.out.println("====== Soham Prabhakar Patil == TEST THREE EXECUTED =======");
    }

    @org.junit.jupiter.api.Test
    void writeFilesIOExceptionTest() throws IOException {
        urinals u = new urinals();
        ArrayList<Integer> trial = new ArrayList<>();
        trial.add(0);
        trial.add(1);
        trial.add(2);
        trial.add(-1);
        u.writeOutput(trial);
        System.out.println("====== Soham Prabhakar Patil == TEST FOUR EXECUTED =======");
    }

    @org.junit.jupiter.api.Test
    void writeFilesDuplicateTest() throws IOException {
        urinals u = new urinals();
        ArrayList<Integer> trial = new ArrayList<>();
        trial.add(0);
        trial.add(1);
        trial.add(2);
        trial.add(-1);
        u.writeOutput(trial);
        System.out.println("====== Soham Prabhakar Patil == TEST FIVE EXECUTED =======");
    }


}