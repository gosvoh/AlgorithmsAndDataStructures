import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Week1dot2 {
    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            FileWriter fileWriter = new FileWriter(outFile);

            long a = scanner.nextLong();
            long b = scanner.nextLong();
            fileWriter.write(Long.toString(a + (b * b)));

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
