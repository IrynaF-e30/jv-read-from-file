import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordExtractor {
    public static List<String> extractWWords(String text) {
        if (text == null || text.isBlank()) {
            return List.of();
        }

        return Arrays.stream(text.toLowerCase().split("[\\s\\p{Punct}]+"))
                .filter(word -> word.startsWith("w"))
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(extractWWords("Width world Wide web"));
        System.out.println(
                extractWWords("WWW? Four-bedroom farmhouse in the countryside. "
                              + "Wave! All of the four double bedrooms are en suite."));
        System.out.println(extractWWords("No words here."));
    }
}
