import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Week1dot1 {
    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            FileWriter fileWriter = new FileWriter(outFile);

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            fileWriter.write(Integer.toString(a + b));

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
