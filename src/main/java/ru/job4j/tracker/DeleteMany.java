package ru.job4j.tracker;

/**
 * Класс удаляет все объявления
 */
public class DeleteMany implements UserAction {
    private final Output out;

    public DeleteMany(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 1; i < 250_002; i++) {
            tracker.delete(i);
        }
        out.println("=== Delete all items ===");
        return true;
    }
}
