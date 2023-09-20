package chapter6.pro2;

public class TicketManager {


    private static TicketManager mgr=null;

    private int limit;

    private int count;

    private TicketManager(){

    }

    public synchronized static TicketManager getInstance(){
        if(mgr==null){
            mgr = new TicketManager();
        }
        return mgr;
    }

    public synchronized void setTicketLimit(int limit){
        this.limit = limit;
    }

    public synchronized Ticket getTicket(){
        if(this.count<this.limit){
            return new NormalTicket(++this.count);
        }
        return new NullTicket();
    }
}
