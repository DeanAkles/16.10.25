import java.util.*;

// Интерфейс для телефонного справочника
interface PhoneDirectory {
    void add(String lastName, String phoneNumber);
    List<String> get(String lastName);
}

// Реализация телефонного справочника
class PhoneBook implements PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneBook() {
        this.directory = new HashMap<>();
    }

    @Override
    public void add(String lastName, String phoneNumber) {
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    @Override
    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public void printAll() {
        System.out.println("\nТелефонный справочник:");
        System.out.println("══════════════════════");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// Класс для работы со словами
class WordProcessor {
    public static void processWords(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nСписок уникальных слов:");
        System.out.println("═══════════════════════");
        for (String uniqueWord : wordCount.keySet()) {
            System.out.println(uniqueWord);
        }

        System.out.println("\nКоличество повторений:");
        System.out.println("═══════════════════════");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)"));
    }
}

// Главный класс приложения
public class TwoInOne {
    public static void main(String[] args) {
        System.out.println("═".repeat(50));
        System.out.println("ОБЪЕДИНЕННЫЙ ПРОЕКТ");
        System.out.println("═".repeat(50));

        // Задача 1: Работа со словами
        System.out.println("\nЗАДАЧА 1: ПОДСЧЕТ СЛОВ");
        System.out.println("═".repeat(30));

        String[] words = {
                "яблоко", "апельсин", "банан", "яблоко",
                "вишня", "банан", "груша", "яблоко",
                "киви", "манго", "виноград", "груша",
                "персик", "слива", "арбуз", "киви"
        };

        System.out.println("Исходный массив: " + Arrays.toString(words));
        WordProcessor.processWords(words);

        // Задача 2: Телефонный справочник
        System.out.println("\n\nЗАДАЧА 2: ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        System.out.println("═".repeat(40));

        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Иванов", "+7-999-123-45-67");
        phoneBook.add("Петров", "+7-912-345-67-89");
        phoneBook.add("Иванов", "+7-917-555-55-55");
        phoneBook.add("Сидоров", "+7-987-654-32-10");
        phoneBook.add("Петров", "+7-916-777-88-99");

        // Поиск номеров
        System.out.println("Поиск по фамилиям:");
        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Кузнецов: " + phoneBook.get("Кузнецов"));

        // Вывод всего справочника
        phoneBook.printAll();

        System.out.println("\n═".repeat(25));
        System.out.println("ПРОГРАММА ЗАВЕРШЕНА");
        System.out.println("═".repeat(25));
    }
}