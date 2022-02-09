package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, String birthday, String category, String lang) {
        super(name, surname, education, birthday, category);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    @Override
    public String toString() {
        return "Programmer{"
                + "\nname= '" + getName() + "', \nsurname= '" + getSurname() + "', \neducation= '" + getEducation()
                + "', \nbirthday= '" + getBirthday()
                + "', \ncategory='" + getCategory() + '\''
                + ", \nlang='" + lang + '\''
                + '\''
                + '}';
    }

    public ErrorReport makeReport(boolean active, int status, String message, String report) {
        return new ErrorReport(active, status, message, report);
    }

    public String repToString(ErrorReport er) {
        return er.toString() + "\n\nОтчет подготовил: \n" + toString();
    }

    public void repToPrint(ErrorReport er) {
        System.out.println(repToString(er));
    }

    public static void main(String[] args) {
        Programmer petr = new Programmer("Petr", "Петров", "Высшее", "18.11.2021", "Senior", "Java");
        ErrorReport newReport = petr.makeReport(true, 25, "Перезагрузите сервер.", "Всё перезагрузили, работает.");
        petr.repToPrint(newReport);

    }
}
