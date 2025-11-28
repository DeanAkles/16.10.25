import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // Создаем массив с повторяющимися словами
        Map<String, Integer> wordCount = getStringIntegerMap();

        // Выводим список уникальных слов
        System.out.println("Список уникальных слов:");
        System.out.println("═══════════════════════");
        for (String uniqueWord : wordCount.keySet()) {
            System.out.println(uniqueWord);
        }

        System.out.println("\nКоличество повторений:");
        System.out.println("═══════════════════════");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }

        // Альтернативный вывод с сортировкой
        System.out.println("\nОтсортированный результат:");
        System.out.println("══════════════════════════");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)"));
    }

    private static Map<String, Integer> getStringIntegerMap() {
        String[] words = {
                "яблоко", "апельсин", "банан", "яблоко",
                "вишня", "банан", "груша", "яблоко",
                "киви", "манго", "виноград", "груша",
                "персик", "слива", "арбуз", "киви"
        };

        // Создаем HashMap для подсчета слов
        Map<String, Integer> wordCount = new HashMap<>();

        // Подсчитываем количество каждого слова
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}