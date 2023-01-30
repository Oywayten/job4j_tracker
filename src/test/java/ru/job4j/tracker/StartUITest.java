package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("0", "Item name", "1")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                List.of("0", String.valueOf(one.getId()), replaceName, "1")
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Edit item" + ln
                + "1. ExitAction Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu:" + ln
                + "0. Edit item" + ln
                + "1. ExitAction Program" + ln
                + "=== ExitAction Program ===" + ln
        );
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("Item name"));
        Input in = new StubInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(
                new FindAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                                             + "0. Show all Item" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== Show all items ===" + ln
                                             + one + ln
                                             + "Menu:" + ln
                                             + "0. Show all Item" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== ExitAction Program ===" + ln
        );
    }

    @Test
    public void whenDeleteItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                List.of("0", id, "1")
        );
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                                             + "0. Delete Item" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== Delete item ===" + ln
                                             + "Заявка удалена успешно" + ln
                                             + "Menu:" + ln
                                             + "0. Delete Item" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== ExitAction Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("Item name"));
        Item two = tracker.add(new Item("Item name2"));
        Input in = new StubInput(
                List.of("0", String.valueOf(one.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                                             + "0. Find Item by id" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== Find item by id ===" + ln
                                             + one + ln
                                             + "Menu:" + ln
                                             + "0. Find Item by id" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== ExitAction Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("Item name"));
        Item two = tracker.add(new Item("Item name2"));
        Item three = tracker.add(new Item("Item name3"));
        Input in = new StubInput(
                List.of("0", "Item name2", "1")
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                                             + "0. Find Items by name" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== Find items by name ===" + ln
                                             + two + ln
                                             + "Menu:" + ln
                                             + "0. Find Items by name" + ln
                                             + "1. ExitAction Program" + ln
                                             + "=== ExitAction Program ===" + ln
        );
    }

    @Test
    public void whenExitTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. ExitAction Program" + System.lineSeparator()
                + "=== ExitAction Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("15", "0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. ExitAction Program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. ExitAction Program" + ln
                + "=== ExitAction Program ===" + ln
        );
    }
}