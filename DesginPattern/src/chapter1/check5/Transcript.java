package chapter1.check5;

public class Transcript {

    private Student student;

    private Course course;

    private String grade;

    private String date;

    public Transcript(Student student,Course course){
        this.student = student;
        student.addTranscript(this);
        this.course = course;
        course.addTranscript(this);
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
