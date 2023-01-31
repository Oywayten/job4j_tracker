package ru.job4j.lombok;

import lombok.*;

import java.util.List;

/**
 * Created by Oywayten on 31.01.2023.
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("permissionTo")
    private List<String> rules;

    public static void main(String[] args) {
        final Permission permission = Permission.of()
                .id(1)
                .name("new")
                .permissionTo("foo")
                .permissionTo("bar")
                .build();
        System.out.println(permission);
    }
}
