import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void readFileTest() {
        urinals u = new urinals();
        String check = "mockFileName";
        try {
            u.readFile(check);
        } catch (final FileNotFoundException e) {
            assertEquals("mockFileName (No such file or directory)", e.getMessage());
            System.out.println("====== Soham Prabhakar Patil == TEST ONE EXECUTED =======");
        }
    }
}