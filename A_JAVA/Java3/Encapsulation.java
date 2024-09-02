package Java3;
class Person{
    private String name;
    private int age;

    //public constructor
    public Person(String name, int age){
        this.name = name;
        setAge(age);
    }
    //public setter age
    public void setAge(int Age){
        if(Age>0){
            this.age=Age;
        }else{
            System.out.println("Age must be graeter than 18 for voting");
        }
    }
    //public setter name
    public void setName(String name){
        this.name=name;
    }
    //public getter name
    public String getName(){
        return name;
    }
    //public getter age
    public int getAge(){
        return age;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Person person=new Person("John Doe",7);
        System.out.println(" Name:"+ person.getName());
        person.setName("Rohan");
        System.out.println("Updated Name:"+ person.getName());
        System.out.println(person.getAge());

    }
}
