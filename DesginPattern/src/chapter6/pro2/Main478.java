package chapter6.pro2;

public class Main478 {

    private static final int NUM=10;

    public static void main(String[] args) {

        TicketManager mgr = TicketManager.getInstance();

        mgr.setTicketLimit(5);

        UserThread[] users = new UserThread[NUM];

        for (int i = 0; i < NUM; i++) {
            users[i] = new UserThread(i + 1 + "-Thread");
            users[i].start();
        }

        for (int i = 0; i < NUM; i++) {
            try {
                users[i].join();
            }catch (InterruptedException e){

            }
        }

        for (int i = 0; i < NUM; i++) {
            if(users[i].getMyTicket().getTicketNum()!=0){
                System.out.println(i+1+"-Thread get Ticket "+users[i].getMyTicket().getTicketNum());
            }
        }

    }
}
