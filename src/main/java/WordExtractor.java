import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordExtractor {

    public static List<String> extractWWords(String text) {
        if (text == null || text.isBlank()) {
            return List.of(); // Повертаємо порожній список, якщо текст порожній
        }

        return Arrays.stream(text.toLowerCase().split("[\\s\\p{Punct}]+")) // Розбиваємо рядок
                .filter(word -> word.startsWith("w"))                      // Відбираємо слова на 'w'
                .sorted()                                                 // Сортуємо природнім чином
                .collect(Collectors.toList());                            // Перетворюємо на список
    }

    public static void main(String[] args) {
        // Тести
        System.out.println(extractWWords("Width world Wide web"));
        // Вивід: [web, wide, width, world]

        System.out.println(extractWWords("WWW? Four-bedroom farmhouse in the countryside. Wave! All of the four double bedrooms are en suite."));
        // Вивід: [wave, www]

        System.out.println(extractWWords("Тут немає слів на w!"));
        // Вивід: []
    }
}
