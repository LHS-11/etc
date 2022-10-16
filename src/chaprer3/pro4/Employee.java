package chaprer3.pro4;

public class Employee {
    private String id;
    private String name;
    private Integer workHours;
    private Integer overTimeHours;

    public Integer getWorkHours() {
        return workHours;
    }

    public Integer getOverTimeHours() {
        return overTimeHours;
    }

    private Logic logic;

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public int calculatePay(){
        return logic.calculate(this);
    }
}
