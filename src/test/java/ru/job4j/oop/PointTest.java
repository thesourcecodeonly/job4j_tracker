package ru.job4j.oop;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void whenThis01AndAnother12Then1dot41() {
        Point one = new Point(0, 1);
        Point that = new Point(1, 2);
        double rsl = one.distance(that);
        double expected = 1.41;
        assertThat(rsl).isCloseTo(expected, Offset.offset(0.01));
    }

    @Test
    public void whenThis011AndAnother122Then1dot73() {
        Point one = new Point(0, 1, 1);
        Point that = new Point(1, 2, 2);
        double rsl = one.distance3D(that);
        double expected = 1.73;
        assertThat(rsl).isCloseTo(expected, Offset.offset(0.01));
    }
}