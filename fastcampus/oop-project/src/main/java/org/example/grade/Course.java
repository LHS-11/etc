package org.example.grade;

public class Course {

    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;

    }

    // getter 만을 사용하기 보다 객체에 메시지를 보냄으로써 응집도를 높여줌, 로직에 대한 변화가 생겼을 때 이 메서드만 수정을 하면 된다.
    public double multiplyCreditAndCourseGrade() {
        return this.credit * this.getGradeToNumber();
    }
}
