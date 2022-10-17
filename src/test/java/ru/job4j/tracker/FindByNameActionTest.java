package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Oywayten on 17.10.2022.
 */
class FindByNameActionTest {

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String foundItem = "Found item";
        Item item = new Item(foundItem);
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + item + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(foundItem);
    }

    @Test
    public void whenFindByNamectionAndItemNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String foundItem = "Found item";
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(foundItem);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString())
                .isEqualTo("=== Find items by name ===" + ln + "Заявки с именем: " + foundItem + " не найдены." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(0);
    }
}