package ru.job4j.lambda;

/**
 * Created by Oywayten on 29.11.2022.
 */
public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Example");
        System.out.printf("Значение равно: " + model.getName());
    }
}
