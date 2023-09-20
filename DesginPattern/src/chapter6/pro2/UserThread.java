package chapter6.pro2;

public class UserThread extends Thread{

    private Ticket myTicket;

    public UserThread(String name){
        super(name);
    }

    public void run(){
        TicketManager mgr = TicketManager.getInstance();
        myTicket = mgr.getTicket();
    }

    public Ticket getMyTicket(){
        return this.myTicket;
    }

}
