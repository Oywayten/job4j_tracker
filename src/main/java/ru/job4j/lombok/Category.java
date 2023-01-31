package ru.job4j.lombok;

import lombok.*;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Category {
    @Getter
    @NonNull
    int id;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude String name;
}