package A_JAVA.Java4;
import Java4.Account;
public class usingPackage {
    public static void main(String[] args) {
        Account s1= new Account();
        s1.name="Deepanshu";
        s1.age=23;
        System.out.println("This file is for using packages");
        System.out.println(s1.name + " " + s1.age);
    }
}
