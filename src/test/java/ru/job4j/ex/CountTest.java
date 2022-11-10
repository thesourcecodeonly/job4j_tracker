package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Count.add(10, 2);
                });
        assertThat(exception.getMessage()).isEqualTo("Start should be less then finish.");
    }

    @Test
    public void whenStart2Finish10IsSum44() {
        int start = 2;
        int finish = 10;
        int expected = 44;
        int result = Count.add(start, finish);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenStart0Finish3IsSum3() {
        int start = 0;
        int finish = 3;
        int expected = 3;
        int result = Count.add(start, finish);
        assertThat(result).isEqualTo(expected);
    }
}