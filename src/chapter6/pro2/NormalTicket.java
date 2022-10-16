package chapter6.pro2;

public class NormalTicket implements Ticket{

    private int serial_num;

    public NormalTicket(int serial_num){
        this.serial_num = serial_num;
    }

    @Override
    public int getTicketNum() {
        return this.serial_num;
    }
}
