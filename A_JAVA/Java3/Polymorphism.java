package A_JAVA.Java3;

//! Polymorphism
class Student{
    String name;
    int age;
    double income;
    
    void printinfo(String name, int age, double income){
        System.out.println("his name is "+ name +" whose age is "+ age + " and his income is "+income);
    }
    void printinfo(String name){
        System.out.println("his name is "+ name );
    }
    void printinfo(String name, int age){
        System.out.println("his name is "+ name +" whose age is "+ age );
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name="Prince";
        s1.age=23;
        s1.income=20000.50;
        s1.printinfo("Deepanshu");
        s1.printinfo(s1.name, s1.age, s1.income);
        s1.printinfo("Rohan", 33);
    }
}
