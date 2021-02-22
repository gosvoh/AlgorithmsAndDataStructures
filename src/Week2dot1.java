import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Week2dot1 {
    private static FileWriter fileWriter = null;

    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            fileWriter = new FileWriter(outFile);

            int count = Integer.parseInt(scanner.nextLine());
            String[] arrayStr = scanner.nextLine().split(" ");
            int[] array = new int[count];
            for (int i = 0; i < array.length; i++) array[i] = Integer.parseInt(arrayStr[i]);

            mergeSort(array, 0, array.length);

            for (int j : array) fileWriter.write(j + " ");

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] array, int startIndex, int endIndex) throws IOException {
        int len = endIndex - startIndex;
        if (len < 2) return;

        int middle = len % 2 == 0 ? len / 2 : len / 2 + 1;
        mergeSort(array, startIndex, startIndex + middle);
        mergeSort(array, startIndex + middle, endIndex);

        merge(array, startIndex, startIndex + middle, endIndex);
    }

    private static void merge(int[] array, int startIndex, int middle, int endIndex) throws IOException {
        int[] leftArray = Arrays.copyOfRange(array, startIndex, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, endIndex);
        int[] resultArray = new int[leftArray.length + rightArray.length];

        int i = 0, j = 0, p = 0;
        int lenLeftArray = leftArray.length, lenRightArray = rightArray.length;
        while (i < leftArray.length || j < rightArray.length)
            if (j == lenRightArray || (i < lenLeftArray && leftArray[i] <= rightArray[j])) {
                resultArray[p] = leftArray[i];
                p++;
                i++;
            } else {
                resultArray[p] = rightArray[j];
                p++;
                j++;
            }

        System.arraycopy(resultArray, 0, array, startIndex, endIndex - startIndex);
        fileWriter.write((startIndex + 1) + " " + endIndex + " " + array[startIndex] + " " + array[endIndex - 1] + "\n");
    }
}
