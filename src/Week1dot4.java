import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Week1dot4 {
    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            FileWriter fileWriter = new FileWriter(outFile);

            int count = Integer.parseInt(scanner.nextLine());
            String[] valsStr = scanner.nextLine().split(" ");
            float[][] vals = new float[count][2];
            for (int i = 0; i < vals.length; i++) {
                vals[i][0] = Float.parseFloat(valsStr[i]);
                vals[i][1] = i + 1;
            }

            for (int i = 1; i < vals.length; i++) {
                float[] tmp = vals[i];
                int j = i;
                while (j > 0 && tmp[0] < vals[j - 1][0]) {
                    vals[j] = vals[j - 1];
                    j--;
                }
                vals[j] = tmp;
            }
            fileWriter.write((int) vals[0][1] + " " + (int) vals[vals.length / 2][1] + " " + (int) vals[vals.length - 1][1]);

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
