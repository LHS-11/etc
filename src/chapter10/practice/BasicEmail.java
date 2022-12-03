package chapter10.practice;

public class BasicEmail extends EmailContent{

    private String content;

    public BasicEmail(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
