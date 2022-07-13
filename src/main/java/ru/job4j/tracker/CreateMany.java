package ru.job4j.tracker;

/**
 * Класс создает 250_000 объявлений в памяти для профилирования программы Memtracker
 */
public class CreateMany implements UserAction {
    private final Output out;

    public CreateMany(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        for (int i = 0; i < 250_000; i++) {
            tracker.add(new Item(String.format("item%s", i)));
        }
        return true;
    }
}
