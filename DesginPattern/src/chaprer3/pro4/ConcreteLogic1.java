package chaprer3.pro4;

public class ConcreteLogic1 implements Logic{

    @Override
    public int calculate(Employee employee) {
        return employee.getOverTimeHours() + employee.getWorkHours();
    }
}
