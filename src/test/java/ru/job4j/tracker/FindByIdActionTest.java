package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Oywayten on 17.10.2022.
 */
class FindByIdActionTest {

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + item + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Found item");
    }

    @Test
    public void whenFindByIdActionAndItemNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + "Заявка с введенным id: 1 не найдена." + ln);
        assertThat(tracker.findAll().size()).isEqualTo(0);
    }
}