import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Week1dot3 {
    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            FileWriter fileWriter = new FileWriter(outFile);

            int count = Integer.parseInt(scanner.nextLine());
            String[] valsStr = scanner.nextLine().split(" ");
            int[] vals = new int[count];
            for (int i = 0; i < vals.length; i++) vals[i] = Integer.parseInt(valsStr[i]);

            fileWriter.write(1 + " ");
            for (int i = 1; i < vals.length; i++) {
                int tmp = vals[i];
                int j = i;
                while (j > 0 && tmp < vals[j - 1]) {
                    vals[j] = vals[j - 1];
                    j--;
                }
                vals[j] = tmp;
                fileWriter.write((j + 1) + " ");
            }
            fileWriter.write("\n");
            for (int val : vals) {
                fileWriter.write(val + " ");
            }

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
