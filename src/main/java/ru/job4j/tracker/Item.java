package ru.job4j.tracker;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Item implements Comparable<Item> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @EqualsAndHashCode.Exclude
    private int id;
    @NonNull
    private String name;
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private LocalDateTime created = LocalDateTime.now();

    public Item(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
        created = LocalDateTime.now();
    }

    @Override
    public int compareTo(Item o) {
        return this.getName().compareTo(o.getName());
    }
}