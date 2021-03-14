import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Week2dot2 {
    private static FileWriter fileWriter = null;
    private static int        counter    = 0;

    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            fileWriter = new FileWriter(outFile);

            int count = Integer.parseInt(scanner.nextLine());
            String[] arrayStr = scanner.nextLine().trim().split(" ");
            int[] array = new int[count];
            for (int i = 0; i < array.length; i++) array[i] = Integer.parseInt(arrayStr[i]);

            mergeSort(array, 0, array.length);

            fileWriter.write(Integer.toString(counter));

            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] array, int startIndex, int endIndex) throws IOException {
        int len = endIndex - startIndex;
        if (len < 2) return;
        if (startIndex == endIndex) return;
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

        /*
         * Этот подсчёт не работает при array.length == 100000
         * TODO Попытаться исправить подсчёт
         */
        while (i < lenLeftArray && j < lenRightArray) {
            if (leftArray[i] > rightArray[j]) {
                counter += lenLeftArray - i;
                j++;
            } else i++;
        }

        i = j = 0;
        while (i < lenLeftArray || j < lenRightArray) {
            if (j == lenRightArray || (i < lenLeftArray && leftArray[i] <= rightArray[j])) {
                resultArray[p] = leftArray[i];
                p++;
                i++;
            } else {
                resultArray[p] = rightArray[j];
                p++;
                j++;
            }
        }

        System.arraycopy(resultArray, 0, array, startIndex, endIndex - startIndex);
    }
}

class wtf {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter(new File("input.txt"));

            fw.write("100000\n");
            for (int i = 100000; i > 0; i--) {
                fw.write(i + " ");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}