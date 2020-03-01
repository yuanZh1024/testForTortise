
//一个类可以使用所属包中的所有类，以及其他包中的public类
//不指定包则在default packge
//javac总在当前目录查找文件 虚拟机只有类路径包括.目录的时候才会查看当前目录
//final类和方法 阻止继承
public class Test
{
    public static void main(String args[]) {
        Manager boss = new Manager("zhang",8000);
        boss.setBonus(2000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("zhi",4000);
        staff[2] = new Employee("yuan",5000);
        //staff[0].setbonus(100);//报错 staff[0]声明的是Employee类型
        Manager[] mans = new Manager[10];
        //mans[0] = new Employee("zz", 123);//错误: 不兼容的类型: Employee无法转换为Manager
        // e : 一个对象变量能够指示多种实际类型不同的对象（Employee/manager)——多态/动态绑定
        for(Employee e: staff) {
            System.out.println("name="+e.getName()+",salary=" + e.getSalary());
        }

        //Manager boss2 = (Manager)staff[1];
        //运行时错误java.lang.ClassCastException: Employee cannot be cast to Manager 向下类型转换
        if(staff[1] instanceof Manager)
        {
            //boss2 = (Manager)staff[1];
        }

        Person[] people = new Person[2];

        people[0] = new Student("zhang","zhi");
        people[1] = new Student("yuan","zhang");

        for(Person p: people) {
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }

}
