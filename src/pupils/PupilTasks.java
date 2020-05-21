package pupils;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PupilTasks {
    public static void main(String[] args) {

        ArrayList<Pupil> pupils = new ArrayList<>();

        Pupil pupil1 = new Pupil();
        Pupil pupil2 = new Pupil();
        Pupil pupil3 = new Pupil();
        Pupil pupil4 = new Pupil();
        Pupil pupil5 = new Pupil();
        Pupil pupil6 = new Pupil();
        Pupil pupil7 = new Pupil();
        Pupil pupil8 = new Pupil();
        Pupil pupil9 = new Pupil();
        Pupil pupil10 = new Pupil();
        pupil1.setPropertiesMen();
        pupil2.setPropertiesMen();
        pupil3.setPropertiesMen();
        pupil4.setPropertiesMen();
        pupil5.setPropertiesMen();
        pupil6.setPropertiesWomen();
        pupil7.setPropertiesWomen();
        pupil8.setPropertiesWomen();
        pupil9.setPropertiesWomen();
        pupil10.setPropertiesWomen();
        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);
        pupils.add(pupil4);
        pupils.add(pupil5);
        pupils.add(pupil6);
        pupils.add(pupil7);
        pupils.add(pupil8);
        pupils.add(pupil9);
        pupils.add(pupil10);
        System.out.println(pupils);

        // ображение к enum Gender через имя класса - Pupil.Gender

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> byGender = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.toCollection(ArrayList::new)));
        byGender.entrySet().forEach(System.out::println);

        // 2. Найти средний возраст учеников
        double averageBirth = pupils.stream()
                .collect(Collectors.averagingInt(Pupil::getBirth));
        System.out.println("Средний возраст учеников - " + averageBirth);

        // 3. Найти самого cтаршего ученика
        Pupil older = pupils.stream()
                .min(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println("самый старший ученик - " + older);

        // 4. Найти самого младшого ученика
        Pupil younger = pupils.stream()
                .max(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println("самый младший ученик - " + younger);

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Pupil>> byBith = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getBirth,
                        Collectors.toCollection(ArrayList::new)));
        byBith.entrySet().forEach(System.out::println);


        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        HashMap<String, Integer> oneName = pupils.stream()
                .collect(Collectors.toMap(
                        Pupil::getName, Pupil::getBirth,
                        (p1, p2) -> p1,
                        HashMap::new));
        oneName.entrySet().forEach(System.out::println);

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> sortedPupils = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth).thenComparing(Pupil::getName))
                .collect(Collectors.toList());
        System.out.println(sortedPupils);

        List<Pupil> sortedPupilsConversely = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender).reversed()
                .thenComparing(Pupil::getBirth).reversed().thenComparing(Pupil::getName)
                        .reversed()).collect(Collectors.toList());
        System.out.println(sortedPupilsConversely);

        // 8. Вывести в косоль всех учеников в возрасте от N до M лет (1997 - 2000)
        ArrayList<Pupil> pupilsAge = pupils.stream()
                .filter(pupil -> pupil.getBirth() >= 1997 && pupil.getBirth() <= 200)
                .collect(Collectors.toCollection(ArrayList::new));
        HashMap<String, Integer> pupilsAge1 = pupilsAge.stream()
                .collect(Collectors.toMap(Pupil::getName,
                        Pupil::getBirth,
                        (p1, p2) -> p1,
                        HashMap::new));
        pupilsAge1.entrySet().forEach(System.out::println);

        // 9. Собрать в список всех учеников с именем=someName (анатолий)
        ArrayList<Pupil> pupilsSomeName = pupils.stream()
                .filter(pupil -> pupil.getName().equals("Анатолий"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(pupilsSomeName);


        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> pupilsSummAge = pupils.stream()
                .collect(Collectors.toMap(Pupil::getGender,
                        pupil -> 2018 - pupil.getBirth(),
                        (p1, p2) -> p1 + p2,
                        HashMap::new));
        pupilsSummAge.entrySet().forEach(System.out::println);

    }

}
