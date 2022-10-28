import java.io.FileNotFoundException;

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
        } catch (final FileNotFoundException e) {
            assertEquals("res/urinals.dat (No such file or directory)", e.getMessage());
            System.out.println("====== Soham Prabhakar Patil == TEST TWO EXECUTED =======");
        }
    }
}