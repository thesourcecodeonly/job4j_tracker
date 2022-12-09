package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average().orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Map<String, Double> map = stream.
                flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.averagingDouble(Subject::score)));
        return map.entrySet().stream()
                .map(stringDoubleEntry ->
                        new Tuple(stringDoubleEntry.getKey(), stringDoubleEntry.getValue()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects().stream().mapToInt(Subject::score).average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects().stream().mapToInt(Subject::score).sum()))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> map = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::score)));
        return map.entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue()))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }
}


