
public class Manager extends Employee
{
    private double bonus;
    public Manager(String name, double salary) {
        super(name,salary);
        //super.getPrivate();//不能访问超类中的私有方法,错误: getPrivate() 在 Employee 中是 private 访问控制
        bonus = 0;
    }
    
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    /*String getName(){
        return "error";// 错误: Manager中的getName()无法覆盖Employee中的getName(),不能低于超类方法中的权限
    }89*/
    public void setBonus(double b) {
        bonus = b;
    }
    
}
