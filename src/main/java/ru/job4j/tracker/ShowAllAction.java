package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    public final Output out;
    
    public ShowAllAction(Output out) {
        this.out = out;
    }
    
    @Override
    public String name() {
        return "Show all Item";
    }

@Override
    public boolean execute(Input input, Tracker tracker) {
    out.println("=== Show all items ===");
    List<Item> items = tracker.findAll();
    if (items.size() > 0) {
        for (Item item : items) {
            out.println(item);
        }
    } else {
        out.println("Хранилище еще не содержит заявок");
    }
    return true;
    }
}
