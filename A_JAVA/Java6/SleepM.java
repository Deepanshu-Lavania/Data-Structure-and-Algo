package A_JAVA.Java6;
class CustomThreadSleep extends Thread{
    CustomThreadSleep(String name){
        super(name);
    }
     public void run(){
        for (int i = 0; i <=10; i++) {
            System.out.println(getName() + " : "+ i);
            try{
                Thread.sleep(300);
            }catch(Exception e){
                System.out.println("Thread sleep for run :"+e);
            }
        }
     }
}
public class SleepM {
    public static void main(String[] args) {
        CustomThreadSleep ct1= new CustomThreadSleep("Thread One");
        CustomThreadSleep ct2= new CustomThreadSleep("Thread two");
        CustomThreadSleep ct3= new CustomThreadSleep("Thread three");
        ct1.start();
        ct2.start();
        ct3.start();
    }
}
