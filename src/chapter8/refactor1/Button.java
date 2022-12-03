package chapter8.refactor1;

public class Button {

    private Command command;

    public Button(Command command){
        setCommand(command);
    }
    public void setCommand(Command command){
        this.command = command;
    }

    public void press(){
        command.execute();
    }
}
