package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 5", 38),
                new Attachment("image 4", 12),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> cmpName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                int result = left.getName().compareTo(right.getName());
                return result == 0 ? Integer.compare(
                        left.getName().length(), right.getName().length()) : result;
            }
        };
        attachments.sort(cmpName);
        System.out.println(attachments);
    }
}
