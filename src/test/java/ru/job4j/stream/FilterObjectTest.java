package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterObjectTest {

    @Test
    public void test() {
        List<FilterObject.User> users = List.of(
                new FilterObject.User("Ivan", 20),
                new FilterObject.User("Boris", 19),
                new FilterObject.User("Benjamin", 18)
        );
        FilterObject.User user = FilterObject.filter(users).iterator().next();
        assertThat("Boris").isEqualTo(user.getName());
        assertThat(19).isEqualTo(user.getAge());
    }
}