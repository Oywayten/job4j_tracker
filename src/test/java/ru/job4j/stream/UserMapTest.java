package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapTest {

    @Test
    public void test() {
        List<Integer> ages = List.of(1, 2);
        List<UserMap.User> result = UserMap.map(ages);
        Iterator<UserMap.User> iterator = result.iterator();
        assertThat(1).isEqualTo(iterator.next().getAge());
        assertThat(2).isEqualTo(iterator.next().getAge());
    }
}