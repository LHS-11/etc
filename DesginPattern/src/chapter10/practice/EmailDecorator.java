package chapter10.practice;

public abstract class EmailDecorator extends EmailContent {

    private EmailContent emailContent;

    public EmailDecorator(EmailContent emailContent){
        this.emailContent = emailContent;
    }

    public String getContent(){
        return emailContent.getContent();
    }
}
