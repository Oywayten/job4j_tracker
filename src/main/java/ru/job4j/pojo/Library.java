package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 217);
        Book javaPhilosophy = new Book("Java Philosophy", 1498);
        Book headFirst = new Book("Head First", 700);
        Book gerbertShildt = new Book("Gerbert Shildt", 3000);
        Book[] library = new Book[4];
        library[0] = cleanCode;
        library[1] = javaPhilosophy;
        library[2] = headFirst;
        library[3] = gerbertShildt;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        System.out.println();
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
        System.out.println();
        for (int i = 0; i < library.length; i++) {
            if (library[i].equals(cleanCode)) {
                System.out.println(library[i]);
            }
        }

        System.out.println();
        for (int i = 0; i < library.length; i++) {
            if (library[i].getName() == "Clean Code") {
                System.out.println(library[i]);
            }
        }
    }
}
