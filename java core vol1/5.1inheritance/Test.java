import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//一个类可以使用所属包中的所有类，以及其他包中的public类
//不指定包则在default packge
//javac总在当前目录查找文件 虚拟机只有类路径包括.目录的时候才会查看当前目录
//final类和方法 阻止继承
public class Test
{
    enum Size { SMALL, MEDIUM };
    public static void main(String args[]) {
        Manager boss = new Manager("zhang",8000);
        boss.setBonus(2000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("zhi",4000);
        staff[2] = new Employee("yuan",5000);
        //staff[0].setbonus(100);//报错 staff[0]声明的是Employee类型
        Manager[] mans = new Manager[10];
        Arrays.sort(staff);
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
        Object obj;
        obj = new int[10];
        /*for(Object tmp: obj) {
            tmp = 1;
            System.out.println(tmp);
        } error*/

        //hashCode

        String s = "ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        String t = new String("ok");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());
        //输出： 3548 1846274136
        //3548 1639705018
        //如果重新定义equals方法 必须重新定义hashCode方法

        Point p = new Point(10,20);
        String printMessage = "point is " + p;//自动调用p.toString
        System.out.println(printMessage);
        System.out.println(System.out);
        int[] nums = {1,2,3};
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));

        ArrayList<Integer> list = new ArrayList<>(100);
        //ArrayList<int> listErr = new ArrayList<>(100); 不能为原始类型primitive
        int loop = 100;
        while(loop > 0) {
            list.add(loop);
            loop--;
        }
        Integer[] list2 = new Integer[list.size()];

        list.toArray(list2);
        System.out.println(Arrays.toString(list2));

        Integer a = 1000; //100
        Integer b = 1000;
        if(a==b) System.out.println("yes");
        if(a.equals(b)) System.out.println("yes2");
        //100的时候 -127～128包装在固定对象 所以两个都相等
        //其他数值 只有第二个比较相等

        String s2 = "101";
        System.out.println(Integer.parseInt(s2));
        String s3 = "001";
        System.out.println(Integer.parseInt(s3,2));

        //5.6枚举类

        //Size是个类 有两个实例——要用==来比较
        Size[] sizes = Size.values();
        System.out.println(Arrays.toString(sizes));// [SMALL, MEDIUM]

        Scanner in = new Scanner(System.in);
        String input = in.next().toUpperCase();
        Size zySize = Enum.valueOf(Size.class, input); //toString的逆向valueof
        System.out.println(zySize);

        Comparable wtf = new Employee("zhang",1);
        if(boss instanceof Comparable) System.out.println("yes");

    }

    //第6章 接口的所有方法自动属于public，可以定义常量，简单方法（se8）
    //接口：类的需求描述
    /*public interface Comparable
    {
        int compareTo(Object other);
    }*/
    //接口中的域自动被视为public static final
    //java不支持多继承
    //public class student extends Person,Comparable——error
    //克隆 内部类 lambda暂放

    //7章 异常派生于Error类或RuntimeException类的异常称为unchecked 其他异常称为checked异常
}
