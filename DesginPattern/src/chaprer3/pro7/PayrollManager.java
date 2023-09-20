package chaprer3.pro7;

import java.util.ArrayList;
import java.util.Iterator;

public class PayrollManager {

    private ArrayList<Employee> employees = new ArrayList<Employee>();

    private PrintManager printManager;

    public void setPrintManager(PrintManager pm){
        this.printManager = pm;
    }

    public void writeEachEmployeePay(){
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext()) {
            Employee emp = iter.next();
            printManager.print(emp.calculatePay());
        }
    }
}
