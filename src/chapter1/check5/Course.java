package chapter1.check5;

import java.util.Iterator;
import java.util.Vector;

public class Course {

    private String name;

    private Vector<Transcript> transcripts;

    public Course(String name){
        this.name = name;
        transcripts = new Vector<Transcript>();
    }

    public void addTranscript(Transcript transcript){
        transcripts.add(transcript);
    }

    public Vector<Course> getCourses(){
        Iterator<Transcript> iter = transcripts.iterator();
        Vector<Course> courses = new Vector<>();
        while (iter.hasNext()) {
            Transcript tc = iter.next();
            courses.add(tc.getCourse());
        }
        return courses;

    }

    public String getName(){
        return name;
    }
}
