package A_JAVA.Java3.Revision;

class Student{
    String name;
    static String school;
}
class Vehicle{
    String name;
}
public class Static {
    static String schoolname = "GBCA";
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name="Rohan";
        Student.school="ABC";
        System.out.println(stu.school);
        System.out.println(Student.school);
        System.out.println(schoolname);
        Vehicle car = new Vehicle();
        car.name="toyota";
        // System.out.println(car.school); //show error because Vehicle class does not exist
        System.out.println(car.name);
    }
}
