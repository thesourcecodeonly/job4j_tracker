package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int amountSubject = pupil.subjects().size();
            int score = 0;
            for (int index = 0; index < amountSubject; index++) {
                score += pupil.subjects().get(index).score();
            }
            int averageScore = score / amountSubject;
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            int amountSubject = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue() / pupils.size();
            result.add(new Label(entry.getKey(), score));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int amountSubject = pupil.subjects().size();
            int score = 0;
            for (int index = 0; index < amountSubject; index++) {
                score += pupil.subjects().get(index).score();
            }
            result.add(new Label(pupil.name(), score));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            int amountSubject = pupil.subjects().size();
            for (int index = 0; index < amountSubject; index++) {
                String key = pupil.subjects().get(index).name();
                int value = pupil.subjects().get(index).score();
                if (map.containsKey(key)) {
                    int score = map.get(key) + value;
                    map.put(key, score);
                } else {
                    map.put(key, value);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue();
            result.add(new Label(entry.getKey(), score));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
