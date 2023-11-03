package org.example;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) { // Главная точка входа в программу
        System.out.println("1 задание"); // Вывод заголовка первого задания
        List<String> list = new ArrayList<>(Arrays.asList("Субзяра", "Смоук", "Смоук", "Лишай", "Смоук", "Субзяра", "Лавки", "Лишай", "Лавки", "Котик")); // Инициализация списка строк

        // обработки списка строк. Для каждой строки подсчитывается количество повторений, а затем выбираются две строки с наибольшим количеством повторений.
        // Результат выводится в виде строки, где имена отделены запятой
        System.out.println(list.stream()//Преобразует список в поток (Stream) элементов
                .collect(groupingBy(Function.identity(), counting()))//Группирует элементы потока по их значениям
                .entrySet().stream()//Преобразует набор пар ключ-значение из предыдущего шага в поток
                .collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())// ищет слово с максимальным количеством повторов
                .map(longTreeSetEntry -> longTreeSetEntry.getValue().stream().limit(2).collect(joining(", ")))
                .orElse(""));//возвращает строку

        System.out.println("2 задание"); // Вывод заголовка второго задания
        // Инициализация списка объектов типа Uchenie
        List<Uchenie> uchenies = new ArrayList<>(
                Arrays.asList(new Uchenie("Менделеев", 1903, "мужской", Uchenie.Fieldofscience.CHEMISTRY),
                        new Uchenie("Эйнштейн", 1845, "мужской", Uchenie.Fieldofscience.MATH),
                        new Uchenie("Эйнштейн2", 1943, "мужской", Uchenie.Fieldofscience.MATH),
                        new Uchenie("Ковалеская", 1942, "женский", Uchenie.Fieldofscience.MATH),
                        new Uchenie("Лавлейс", 1956, "женский", Uchenie.Fieldofscience.BIOLOGY),
                        new Uchenie("Ламарк", 1985, "мужской", Uchenie.Fieldofscience.BIOLOGY),
                        new Uchenie("Иванова", 2005, "женский", Uchenie.Fieldofscience.MATH),
                        new Uchenie("Лапласовс", 1689, "женский", Uchenie.Fieldofscience.MATH),
                        new Uchenie("Ламарков", 1954, "мужской", Uchenie.Fieldofscience.MATH)
                ));

        printNExpensive(uchenies); // Вызов метода printNExpensive
    }

    // Метод для вывода имен ученых, отсортированных сначала по полу, затем по возрасту (в обратном порядке)

    public static void printNExpensive(List<Uchenie> uchenies) {
        System.out.println(
                uchenies.stream()  // Стрим из списка ученых
                        .filter(u -> u.getFieldofscience() == Uchenie.Fieldofscience.MATH).limit(3) // отфильтровываем только математиков
                        .sorted(Comparator.comparing(Uchenie::getPol)
                                .thenComparing(Uchenie::getYear).reversed()) // сортировка сначала по полу, и, наконец, по возрасту (в обратном порядке)
                        .map(Uchenie::getSurname)// для каждого ученого выбирается его имя
                        .collect(joining(", ", "Ученые в области: ", ";"))); // все фамилии объединяются в одну строку с разделителем ", "
    }
}