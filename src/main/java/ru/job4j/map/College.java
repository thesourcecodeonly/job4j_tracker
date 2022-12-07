package ru.job4j.map;

import java.util.Map;
import java.util.Set;
import java.util.Optional;

public class College {

    private final Map<Student, Set<Subjects>> students;

    public College(Map<Student, Set<Subjects>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subjects> findBySubjectName(String account, String name) {
        Optional<Subjects> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subjects> subjects = students.get(s.get());
            for (Subjects subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
