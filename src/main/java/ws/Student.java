package ws;

public class Student {
    private String name;
    private String surname;
    private int group;
    private int averageScore;
    private int idStudent;

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getGroup() {
        return group;
    }

    public Student setGroup(int group) {
        this.group = group;
        return this;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public Student setAverageScore(int averageScore) {
        this.averageScore = averageScore;
        return this;
    }

    public String getName() {

        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public Student setIdStudent(int idStudent) {
        this.idStudent = idStudent;
        return this;
    }
}
