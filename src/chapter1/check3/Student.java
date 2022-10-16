package chapter1.check3;

public class Student {

    private Professor advisor;

    public void setAdvisor(Professor advisor){
        this.advisor = advisor;
    }

    public void advise(String msg){
        System.out.println(msg);
    }
}
