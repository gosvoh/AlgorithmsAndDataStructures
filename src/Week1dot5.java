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

            for (int i = 1; i < vals.length; i++) {
                int tmp = vals[i];
                int j = i;
                while (j > 0 && tmp < vals[j - 1]) {
                    vals[j] = vals[j - 1];
                    j--;
                }
                vals[j] = tmp;
                if (i != j) fileWriter.write(String.format("Swap elements at indices %d and %d.\n", j + 1, i + 1));
            }
            System.out.println(Arrays.toString(vals));
            fileWriter.write("No more swaps needed.");
            scanner.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
