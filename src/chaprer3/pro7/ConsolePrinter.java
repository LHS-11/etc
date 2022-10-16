package chaprer3.pro7;


public class ConsolePrinter implements PrintManager {
    @Override
    public void print(int pay) {
        System.out.println(pay);
    }
}
