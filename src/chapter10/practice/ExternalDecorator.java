package chapter10.practice;

public class ExternalDecorator extends EmailDecorator{

    public ExternalDecorator(EmailContent emailContent) {
        super(emailContent);
    }

    public String getContent(){
        String content = super.getContent();
        String externalContent = addDisclaimer(content);
        return externalContent;
    }

    public String addDisclaimer(String content){
        return content + " Company Disclaimer";
    }
}
