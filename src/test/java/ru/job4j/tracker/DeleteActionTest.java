package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Oywayten on 17.10.2022.
 */
class DeleteActionTest {
    @Test
    public void whenDelete() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        String deletedName = "New item name";
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(deletedName);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===" + ln + "Заявка удалена успешно" + ln);
        assertThat(tracker.findAll().size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteAndItemNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===" + ln + "Ошибка удаления заявки" + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Deleted item");
    }
}