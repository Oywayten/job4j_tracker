package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
            throw new ElementNotFoundException("Element not found");
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abus : abuses) {
            if (value.equals(abus)) {
                throw new ElementAbuseException("Element abuse");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] s = {"dfs", "dsgsd"};
        try {
            indexOf(s, "dfsd");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
