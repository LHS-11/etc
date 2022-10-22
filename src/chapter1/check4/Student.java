package chapter1.check4;

import java.util.Vector;


public class Student {

    private String name;

    private Vector<Course> courses;

    public Student(String name){
        this.name = name;
        courses = new Vector<Course>();
    }

    public void registerCourse(Course course){
        courses.add(course);
    }

    public void dropCourse(Course course){
        if (courses.contains(course)) {
            courses.remove(course);
        }
    }

    public Vector<Course> getCourses(){
        return courses;
    }

    public String getName(){
        return this.name;
    }


}
