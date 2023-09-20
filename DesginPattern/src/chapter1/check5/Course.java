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



    public Vector<Student> getStudents(){
        Iterator<Transcript> iter = transcripts.iterator();
        Vector<Student> students = new Vector<Student>();
        while(iter.hasNext()){
            Transcript tc = iter.next();
            students.add(tc.getStudent());
        }
        return students;
    }

    public String getName(){
        return name;
    }
}
