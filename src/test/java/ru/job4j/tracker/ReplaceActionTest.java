package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Oywayten on 16.10.2022.
 */
class ReplaceActionTest {
    @Test
    public void whenReplace() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===" + ln + "Заявка изменена успешно." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenReplaceAndItemNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===" + ln + "Ошибка замены заявки." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Replaced item");
    }
}