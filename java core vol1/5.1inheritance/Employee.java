import com.sun.tools.internal.ws.processor.model.ExtendedModelVisitor;
import javafx.beans.binding.ObjectExpression;

public class Employee
{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double bypercent){
        double raise = salary * bypercent / 100;
        salary += raise;
    }
    private void getPrivate(){
        return;
    }
    public boolean equals(Object other) {
        if(this == other) return true;
        if(other == null) return false;
        if(getClass() != other.getClass()) { //返回对象所属的类
            return false;
        }

        Employee em = (Employee)other;

        return name.equals(em.name)
                && salary == em.salary;
        //为了防止name为Null
        return Object(name, em.name);
        //如果两个参数都不为null 则调用 a.equals(b)

        if(!(other instanceof Employee)) return false;
        //如果调用employee.equals(manager)
    }
}
