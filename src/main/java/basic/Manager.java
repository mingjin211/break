package basic;

public class Manager extends Employee {

    private double bonus;

    public Manager(){
        this.bonus = 0;
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary(){
        return super.getSalary() + bonus;
    }
}
