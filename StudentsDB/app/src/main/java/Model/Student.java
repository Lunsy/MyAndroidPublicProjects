package Model;

public class Student {
    private int id;
    private String faculty;
    private String firstName;
    private String lastName;
    private String aveGrades;

    public Student() {
    }

    public Student(int id, String faculty, String firstName, String lastName, String aveGrades) {
        this.id = id;
        this.faculty = faculty;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aveGrades = aveGrades;
    }

    public Student(String faculty, String firstName, String lastName, String aveGrades) {
        this.faculty = faculty;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aveGrades = aveGrades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAveGrades() {
        return aveGrades;
    }

    public void setAveGrades(String aveGrades) {
        this.aveGrades = aveGrades;
    }
}
