import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        File file = new File("/Users/inna/java files/топ 10 слов stream/Весна.txt"); // содержимое файла может быть любым
         Files.lines(Paths.get("/Users/inna/java files/топ 10 слов stream/Весна.txt"), StandardCharsets.UTF_8)
                 .flatMap(w -> Arrays.stream(w.split("\\PL+")))
                 .filter(w -> w.length() > 0)
                 .map(String::toLowerCase)
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                 .entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .limit(10)
                 .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

         //и=3
        //с=3
        //пришла=2
        //снег=2
        //весна=2
        //деревьях=1
        //день=1
        //их=1
        //трава=1
        //сквозь=1


    }
}
