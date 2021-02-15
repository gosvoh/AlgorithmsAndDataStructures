import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Неверный ответ, тест 8
 * Комментарий проверяющей программы:
 *
 * Сценарий сортировки неправильный: элементы на индексах 2 и 3 не отсортированы!
 * Фрагмент массива после выполнения перестановок, выведенных Вашей программой: [1, 5, 3]
 *
 * Подсказка: в этом тесте три элемента, упорядоченные по убыванию.
 *
 * TODO Пофиксить этот баг, но я хз как
 */
public class Week1dot5 {
    private static FileWriter fileWriter = null;

    public static void quickSort(int[] array, int low, int high) throws IOException {
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        int reference = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < reference) i++;
            while (array[j] > reference) j--;

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i != j) fileWriter.write(String.format("Swap elements at indices %d and %d.\n", i + 1, j + 1));
                i++;
                j--;
            }
        }

        if (low < j) quickSort(array, low, j);

        if (high > i) quickSort(array, i, high);
    }

    public static void main(String[] args) {
        File inFile = new File("input.txt");
        File outFile = new File("output.txt");

        try {
            Scanner scanner = new Scanner(inFile);
            fileWriter = new FileWriter(outFile);

            int count = Integer.parseInt(scanner.nextLine());
            String[] valsStr = scanner.nextLine().split(" ");
            int[] vals = new int[count];
            for (int i = 0; i < vals.length; i++) vals[i] = Integer.parseInt(valsStr[i]);

            quickSort(vals, 0, count - 1);

            fileWriter.write("No more swaps needed.");
            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
